package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.Pessoa;
import br.senac.go.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("api/pessoa")
@Tags({
        @Tag(name = "pessoa", description = "documentação ao resource pessoa"),
})
public class PessoaResource implements IResource<Pessoa, Integer> {

    @Autowired
    private PessoaService pessoaService;

    @Override
    @Operation(
            summary = "Criar uma pessoa",
            description = "Método responsável por criar uma pessoa no sistema",
            tags = { "pessoa"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
    })
    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Pessoa create(@Valid @RequestBody Pessoa entity) {
        log.info("Executado método PessoaResource.create");
        log.debug(String.format("Executado método PessoaResource.create | valores: %s",entity.toString()));
        return pessoaService.create(entity);
    }

    @Override
    @Operation(
            summary = "Recupera varias pessoa",
            description = "Método responsável para recuperar varias pessoa no sistema",
            tags = { "pessoa" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @GetMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Pessoa read(@Valid @RequestBody Pessoa entity) throws Exception {
        log.info("Executado método PessoaResource.read");
        log.debug(String.format("Executado método PessoaResource.read | valores: %s",entity.toString()));
        return pessoaService.read(entity);
    }

    @Override
    @Operation(
            summary = "Recupera uma pessoa",
            description = "Método responsável para recuperar uma pessoa no sistema",
            tags = { "pessoa" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Pessoa readById(@PathVariable("id") Integer id) throws Exception {
        log.info("Executado método PessoaResource.readById");
        log.debug(String.format("Executado método PessoaResource.readById | valores: %d",id));
        return pessoaService.readById(id);
    }

    @Override
    @Operation(
            summary = "Alterar uma parte da pessoa",
            description = "Método responsável para alterar uma parte da pessoa no sistema",
            tags = { "pessoa" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @PatchMapping(value ="/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Pessoa updatePart(@PathVariable("id") Integer id, @Valid @RequestBody Pessoa entity) throws Exception {
        log.info("Executado método PessoaResource.update");
        log.debug(String.format("Executado método PessoaResource.update | valores: %s",entity.toString()));
        return pessoaService.updatePart(id, entity);
    }

    @Override
    @Operation(
            summary = "Alterar uma pessoa toda",
            description = "Método responsável para alterar uma pessoa por completo no sistema",
            tags = { "pessoa" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @PutMapping(value = "/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Pessoa updateFull(@PathVariable("id") Integer id, @Valid @RequestBody Pessoa entity) {
        log.info("Executado método PessoaResource.update");
        log.debug(String.format("Executado método PessoaResource.update | valores: %s",entity.toString()));
        return pessoaService.updateFull(id, entity);
    }

    @Override
    @Operation(
            summary = "Alterar uma pessoa",
            description = "Método responsável para alterar uma pessoa no sistema",
            tags = { "pessoa" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Pessoa update(@Valid @RequestBody Pessoa entity) {
        log.info("Executando metodo update");
        log.debug(String.format("Executado método PessoaResource.update | valores: %s",entity.toString()));
        return pessoaService.updateFull(entity);
    }

    @Override
    @Operation(
            summary = "Deletar uma pessoa",
            description = "Método responsável por deletar uma pessoa no sistema",
            tags = { "pessoa" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        log.info("Executado método PessoaResource.delete");
        log.debug(String.format("Executado método PessoaResource.delete | valores: %d",id));
        pessoaService.deleteById(id);
    }

    @Override
    @Operation(
            summary = "Deletar uma pessoa",
            description = "Método responsável para Deletar uma pessoa no sistema",
            tags = { "pessoa" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @DeleteMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public void deleteByEntity(@Valid @RequestBody Pessoa entity) {
        log.info("Executado método PessoaResource.delete");
        log.debug(String.format("Executado método PessoaResource.delete | valores: %s",entity.toString()));
        pessoaService.delete(entity);
    }
}
