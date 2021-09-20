from flask import Flask, request, jsonify, make_response
from flask_sqlalchemy import SQLAlchemy
from werkzeug.security import generate_password_hash, check_password_hash
import uuid
import jwt
import datetime
from functools import wraps

app = Flask(__name__)

app.config['SECRET_KEY']='cb5e3f9a60da885fc6f7a0ee2eeed878'
app.config['SQLALCHEMY_DATABASE_URI']='sqlite://///home/wrpires/code/repos/python/jwt/bookstore.db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = True

db = SQLAlchemy(app)

class Users(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    public_id = db.Column(db.Integer)
    name = db.Column(db.String(50))
    password = db.Column(db.String(50))
    role = db.Column(db.String(50))

class Books(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    user_id = db.Column(db.Integer, db.ForeignKey('users.id'), nullable=False)
    name = db.Column(db.String(50), unique=True, nullable=False)
    Author = db.Column(db.String(50), unique=True, nullable=False)
    Publisher = db.Column(db.String(50), nullable=False)
    Year = db.Column(db.Integer, nullable=False)

validTokens = []

def token_required(f):
    @wraps(f)
    def decorator(*args, **kwargs):

        token = None

        if 'x-access-tokens' in request.headers:
            token = request.headers['x-access-tokens']

        if not token:
            response = jsonify({'message': 'a valid token is missing'})
            return response, 403
        
        if token not in validTokens:
            response = jsonify({'message': 'token is invalid'})
            return response, 403

        try:
            data = jwt.decode(token, app.config['SECRET_KEY'], algorithms=["HS256"])
            current_user = Users.query.filter_by(public_id=data['public_id']).first()
        except:
            response = jsonify({'message': 'token is invalid'})
            return response, 403

        return f(current_user, *args, **kwargs)
    return decorator


@app.route('/register', methods=['POST'])
def signup_user():  
    data = request.get_json()  

    hashed_password = generate_password_hash(data['password'], method='sha256')
 
    new_user = Users(public_id=str(uuid.uuid4()), name=data['name'], password=hashed_password, role=data['role']) 
    db.session.add(new_user)  
    db.session.commit()    

    return jsonify({'message': 'registeration successfully'})

@app.route('/login', methods=['POST'])  
def login_user(): 
    auth = request.authorization   

    if not auth or not auth.username or not auth.password:  
        return make_response('could not verify', 401, {'Authentication': 'login required"'})    

    user = Users.query.filter_by(name=auth.username).first()   
     
    if check_password_hash(user.password, auth.password):

        token = jwt.encode({'public_id' : user.public_id, 'exp' : datetime.datetime.utcnow() + datetime.timedelta(minutes=5)}, app.config['SECRET_KEY'], "HS256")
        validTokens.append(token)

        return jsonify({'token' : token}) 

    return make_response('could not verify',  401, {'Authentication': '"login required"'})

@app.route('/logout', methods=['POST'])  
def logout_user(): 
    auth = request.authorization   

    if not auth or not auth.username or not auth.password:  
        return make_response('could not verify', 401, {'Authentication': 'login required"'})    

    user = Users.query.filter_by(name=auth.username).first()   
     
    if check_password_hash(user.password, auth.password):

        token = jwt.encode({'public_id' : user.public_id, 'exp' : datetime.datetime.utcnow() + datetime.timedelta(minutes=5)}, app.config['SECRET_KEY'], "HS256")
        validTokens.remove(token)
        return jsonify("logged out successfully") 

    return make_response('could not verify',  401, {'Authentication': '"login required"'})

@app.route('/users', methods=['GET'])
def get_all_users():  
   
    users = Users.query.all() 
    result = []   
    for user in users:   
        user_data = {}   
        user_data['public_id'] = user.public_id  
        user_data['name'] = user.name 
        user_data['password'] = user.password
        user_data['role'] = user.role 
       
        result.append(user_data)   

    return jsonify(result)

@app.route('/books', methods=['POST'])
@token_required
def create_book(current_user):
   
    data = request.get_json() 

    book = Books(name=data['name'], Author=data['author'], Publisher=data['publisher'], Year=data['year'], user_id=current_user.id)  
    db.session.add(book)   
    db.session.commit()   

    book_data = {}
    book_data['id'] = book.id
    book_data['name'] = book.name
    book_data['author'] = book.Author
    book_data['publisher'] = book.Publisher
    book_data['year'] = book.Year

    return jsonify(book_data)


@app.route('/books', methods=['GET'])
@token_required
def get_books(current_user):

    books = Books.query.filter_by(user_id=current_user.id).all()

    output = []
    for book in books:
        book_data = {}
        book_data['id'] = book.id
        book_data['name'] = book.name
        book_data['author'] = book.Author
        book_data['publisher'] = book.Publisher
        book_data['year'] = book.Year
        output.append(book_data)

    return jsonify(output)

@app.route('/users/<public_id>', methods=['GET'])
@token_required
def get_user(current_user, user_id):  
    user = Users.query.filter_by(public_id=public_id, user_id=current_user.id).first()   
    if not user:   
        return jsonify({'message': 'user does not exist'})   

    return jsonify(user)


@app.route('/books/<book_id>', methods=['DELETE'])
@token_required
def delete_book(current_user, book_id):  
    book = Books.query.filter_by(id=book_id, user_id=current_user.id).first()   
    if not book:   
        return jsonify({'message': 'book does not exist'})   

    db.session.delete(book)  
    db.session.commit()   

    return jsonify({'message': 'Book deleted'})

@app.route('/books/<book_id>', methods=['GET'])
@token_required
def get_book(current_user, book_id):  
    book = Books.query.filter_by(id=book_id, user_id=current_user.id).first()   
    if not book:   
        return jsonify({'message': 'book does not exist'})   

    book_data = {}
    book_data['id'] = book.id
    book_data['name'] = book.name
    book_data['author'] = book.Author
    book_data['publisher'] = book.Publisher
    book_data['year'] = book.Year

    return jsonify(book_data)


if  __name__ == '__main__':  
     app.run(debug=True)