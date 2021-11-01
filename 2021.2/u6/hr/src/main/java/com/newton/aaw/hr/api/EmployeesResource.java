package com.newton.aaw.hr.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("/v1/employees")
public interface EmployeesResource {

	@Operation(summary = "Recupera um Employee a partir de um ID")
	@ApiResponses(value = {
			@ApiResponse(
					description = "um Employee retornado com sucesso", 
					responseCode = "200", 
					content =  {
							@Content(
									mediaType = "application/json",
									schema = @Schema(implementation = EmployeeDto.class))
					}),
			@ApiResponse(
					description = "Employee com ID não encontrado", 
					responseCode = "404",
					content = {
							@Content(
									mediaType = "application/json",
									schema = @Schema(implementation = ErrorResponseDto.class))
					})
	})
	@GetMapping("/{id}")
	EmployeeDto getById(String id);

	@Operation(summary = "Recupera todos os Employees")
	@GetMapping
	List<EmployeeDto> getAll();

	@Operation(summary = "Permite criar um novo Employee")
	@PostMapping
	EmployeeDto create(EmployeeDto employeeDto);

	@Operation(summary = "Atualiza um Employee existente a partir de um ID")
	@PutMapping("/{id}")
	EmployeeDto update(String id, EmployeeDto employeeDto);

	@Operation(summary = "Excluir um Employee a partir de um ID")
	@DeleteMapping("/{id}") 
	ResponseEntity<Void> delete(String id);
}