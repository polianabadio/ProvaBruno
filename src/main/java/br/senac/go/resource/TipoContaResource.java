package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.TipoConta;
import br.senac.go.service.TipoContaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/tipoconta")
@Tag(name = "tipoconta", description = "documentação ao resource tipo conta")
public class TipoContaResource implements IResource<TipoConta, Integer>
{
    @Autowired
    TipoContaService tipoContaService;

    @Override
    @Operation(
            summary = "Cria um tipo de conta",
            description = "Método responsável para criar um tipo de conta no sistema.",
            tags = { "tipoconta" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public TipoConta create(@Valid @RequestBody TipoConta entity)
    {
        log.info("Executado método TipoContaResource.create");
        log.debug(String.format("Executando método TipoContaResource.create | valores: %s",entity.toString()));

        TipoConta tipoConta = tipoContaService.create(entity);

        return tipoConta;
    }

    @Override
    @Operation(
            summary = "Recupera um tipo de conta",
            description = "Método responsável para recuperar um tipo conta no sistema.",
            tags = { "tipoconta" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public TipoConta read(@Valid @RequestBody TipoConta entity) throws Exception
    {
        log.info("Executado método ContaResource.read");
        log.debug(String.format("Executando método ContaResource.read | valores: %s",entity.toString()));

        TipoConta tipoConta = tipoContaService.read(entity);

        return tipoConta;
    }

    @Override
    @Operation(
            summary = "Recupera um tipo de conta baseada no identificador",
            description = "Método responsável para recuperar um tipo de conta no sistema baseado no identificador.",
            tags = { "tipoconta" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public TipoConta readById(@PathVariable("id") Integer id) throws Exception
    {
        log.info("Executado método TipoContaResource.readById");
        log.debug(String.format("Executando método TipoContaResource.readById | valores: %d",id));

        TipoConta tipoConta = tipoContaService.readById(id);

        return tipoConta;
    }

    @Override
    @Operation(
            summary = "Atualiza um tipo de conta",
            description = "Método responsável para atualizar um tipo de conta no sistema.",
            tags = { "tipoconta" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public TipoConta update(@Valid @RequestBody TipoConta entity)
    {
        log.info("Executado método TipoContaResource.update");
        log.debug(String.format("Executando método TipoContaResource.update | valores: %s",entity.toString()));

        TipoConta tipoConta = tipoContaService.updateFull(entity);

        return tipoConta;
    }

    @Override
    @Operation(
            summary = "Atualiza parte dos dados de um tipo de conta",
            description = "Método responsável para atualizar parte dos dados de um tipo de conta no sistema.",
            tags = { "tipoconta" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public TipoConta updatePart(@PathVariable("id") Integer id, @Valid @RequestBody TipoConta entity) throws Exception
    {
        log.info("Executado método TipoContaResource.updatePart");
        log.debug(String.format("Executando método TipoContaResource.updatePart | valores: %d, %s",id,entity));

        TipoConta tipoConta = tipoContaService.updatePart(id, entity);

        return tipoConta;
    }

    @Override
    @Operation(
            summary = "Atualiza todos os dados de um tipo de conta",
            description = "Método responsável para atualizar todos os dados de um tipo de conta no sistema.",
            tags = { "tipoconta" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping("/{id}")
    public TipoConta updateFull(@PathVariable("id") Integer id, @Valid @RequestBody TipoConta entity)
    {
        log.info("Executado método TipoContaResource.updateFull");
        log.debug(String.format("Executando método TipoContaResource.updateFull | valores: %d, %s",id,entity));

        TipoConta tipoConta = tipoContaService.updateFull(id, entity);

        return tipoConta;
    }

    @Override
    @Operation(
            summary = "Deleta um tipo de conta com base no identificador",
            description = "Método responsável para deletar um tipo de conta no sistema com base no identificador.",
            tags = { "tipoconta" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id)
    {
        log.info("Executado método TipoContaResource.delete");
        log.debug(String.format("Executando método TipoContaResource.delete | valores: %d",id));

        tipoContaService.deleteById(id);
    }

    @Override
    @Operation(
            summary = "Deleta um tipo de conta",
            description = "Método responsável para deletar um tipo de conta no sistema.",
            tags = { "tipoconta" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteByEntity(@Valid @RequestBody TipoConta entity)
    {
        log.info("Executado método TipoContaResource.deleteByEntity");
        log.debug(String.format("Executando método TipoContaResource.deleteByEntity | valores: %s",entity.toString()));

        tipoContaService.delete(entity);
    }
}