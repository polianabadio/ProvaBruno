package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.Investimento;
import br.senac.go.service.InvestimentoService;
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
@RequestMapping("api/investimento")
@Tags({
        @Tag(name = "investimento", description = "documentação ao resource investimento"),
})
public class InvestimentoResource implements IResource<Investimento, Integer> {

    @Autowired
    private InvestimentoService investimentoService;

    @Override
    @Operation(
            summary = "Criar uma investimento",
            description = "Método responsável por criar uma investimento no sistema",
            tags = { "investimento"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
    })
    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Investimento create(@Valid @RequestBody Investimento entity) {
        log.info("Executado método InvestimentoResource.create");
        log.debug(String.format("Executado método InvestimentoResource.create | valores: %s",entity.toString()));
        return investimentoService.create(entity);
    }

    @Override
    @Operation(
            summary = "Recupera varias investimento",
            description = "Método responsável para recuperar varias investimento no sistema",
            tags = { "investimento" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @GetMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Investimento read(@Valid @RequestBody Investimento entity) throws Exception {
        log.info("Executado método InvestimentoResource.read");
        log.debug(String.format("Executado método InvestimentoResource.read | valores: %s",entity.toString()));
        return investimentoService.read(entity);
    }

    @Override
    @Operation(
            summary = "Recupera uma investimento",
            description = "Método responsável para recuperar uma investimento no sistema",
            tags = { "investimento" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Investimento readById(@PathVariable("id") Integer id) throws Exception {
        log.info("Executado método InvestimentoResource.readById");
        log.debug(String.format("Executado método InvestimentoResource.readById | valores: %d",id));
        return investimentoService.readById(id);
    }

    @Override
    @Operation(
            summary = "Alterar uma parte da investimento",
            description = "Método responsável para alterar uma parte da investimento no sistema",
            tags = { "investimento" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @PatchMapping(value ="/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Investimento updatePart(@PathVariable("id") Integer id, @Valid @RequestBody Investimento entity) throws Exception {
        log.info("Executado método InvestimentoResource.update");
        log.debug(String.format("Executado método InvestimentoResource.update | valores: %s",entity.toString()));
        return investimentoService.updatePart(id, entity);
    }

    @Override
    @Operation(
            summary = "Alterar uma investimento toda",
            description = "Método responsável para alterar uma investimento por completo no sistema",
            tags = { "investimento" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @PutMapping(value = "/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Investimento updateFull(@PathVariable("id") Integer id, @Valid @RequestBody Investimento entity) {
        log.info("Executado método InvestimentoResource.update");
        log.debug(String.format("Executado método InvestimentoResource.update | valores: %s",entity.toString()));
        return investimentoService.updateFull(id, entity);
    }

    @Override
    @Operation(
            summary = "Alterar uma investimento",
            description = "Método responsável para alterar uma investimento no sistema",
            tags = { "investimento" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Investimento update(@Valid @RequestBody Investimento entity) {
        log.info("Executando metodo update");
        log.debug(String.format("Executado método InvestimentoResource.update | valores: %s",entity.toString()));
        return investimentoService.updateFull(entity);
    }

    @Override
    @Operation(
            summary = "Deletar uma investimento",
            description = "Método responsável por deletar uma investimento no sistema",
            tags = { "investimento" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        log.info("Executado método InvestimentoResource.delete");
        log.debug(String.format("Executado método InvestimentoResource.delete | valores: %d",id));
        investimentoService.deleteById(id);
    }

    @Override
    @Operation(
            summary = "Deletar uma investimento",
            description = "Método responsável para Deletar uma investimento no sistema",
            tags = { "investimento" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @DeleteMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public void deleteByEntity(@Valid @RequestBody Investimento entity) {
        log.info("Executado método InvestimentoResource.delete");
        log.debug(String.format("Executado método InvestimentoResource.delete | valores: %s",entity.toString()));
        investimentoService.delete(entity);
    }
}
