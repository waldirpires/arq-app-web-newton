'use strict';

var utils = require('../utils/writer.js');
var Pet = require('../service/PetService');

module.exports.criarPet = function criarPet (req, res, next) {
  var body = req.swagger.params['body'].value;
  Pet.criarPet(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.deletePetById = function deletePetById (req, res, next) {
  var id = req.swagger.params['id'].value;
  Pet.deletePetById(id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getAllPets = function getAllPets (req, res, next) {
  Pet.getAllPets()
    .then(function (response) {
      utils.writeJson(res, [response]);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getPetById = function getPetById (req, res, next) {
  var id = req.swagger.params['id'].value;
  Pet.getPetById(id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.updatePetById = function updatePetById (req, res, next) {
  var id = req.swagger.params['id'].value;
  var body = req.swagger.params['body'].value;
  Pet.updatePetById(id,body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
