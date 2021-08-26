var express = require("express");
var app = express();

let posts = [{'id': 1, 'name': 'john', 'text': 'info'}, {'id': 2, 'name': 'sarah', 'text': 'info2'}]

app.get("/posts", (req, res, next) => {
 res.json(posts);
})

app.get("/posts/:id", (req, res, next) => {
 console.log('here: ' + req.params.id);
 let found = null;
 for (let i = 0; i < posts.length; i++) { 
   console.log('here2:' + posts[i]);
   console.log(posts[i].id === req.params.id);
   if (posts[i].id === parseInt(req.params.id)) {
     found = posts[i];
     res.json(found)
     
     break;
   }
 }

  if (found == null) {
    res.status(404).json({message: 'Subscriber not found'})
  } 
})

app.listen(3000, () => {
 console.log("Server running on port 3000");
});

