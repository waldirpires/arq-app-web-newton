'use strict';

var utils = require('../utils/writer.js');
var Default = require('../service/DefaultService');

module.exports.getEmployeeById = function getEmployeeById (req, res, next) {
  var id = req.swagger.params['id'].value;
  Default.getEmployeeById(id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getEmployees = function getEmployees (req, res, next) {
  Default.getEmployees()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
