'use strict';


/**
 * Cria un novo Pet.
 *
 * body Pet Pet a ser criado
 * returns Pet
 **/
exports.criarPet = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {"empty": false};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Deleta um Pet da loja a partir do ID.
 *
 * id String ID do Pet a ser retornado
 * no response value expected for this operation
 **/
exports.deletePetById = function(id) {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Lista todos os Pets da loja.
 *
 * returns List
 **/
exports.getAllPets = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Retorna um Pet da loja a partir do ID.
 *
 * id String ID do Pet a ser retornado
 * returns Pet
 **/
exports.getPetById = function(id) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {"empty": false};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Atualiza um Pet da loja a partir do ID.
 *
 * id String ID do Pet a ser retornado
 * body Pet Pet a ser criado
 * returns Pet
 **/
exports.updatePetById = function(id,body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {"empty": false};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

