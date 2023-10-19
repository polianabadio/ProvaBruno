package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.TipoInvestimento;
import br.senac.go.service.TipoInvestimentoService;
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
@RequestMapping(path = "/api/tipoinvestimento")
@Tag(name = "tipoinvestimento", description = "documentação ao resource tipo de investimento")
public class TipoInvestimentoResource implements IResource<TipoInvestimento,Integer>
{
    @Autowired
    TipoInvestimentoService tipoInvestimentoService;

    @Override
    @Operation(
            summary = "Cria um tipo de investimento",
            description = "Método responsável para criar um tipo de investimento no sistema.",
            tags = { "tipoinvestimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = TipoInvestimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public TipoInvestimento create(@Valid @RequestBody TipoInvestimento entity)
    {
        log.info("Executado método TipoInvestimentoResource.create");
        log.debug(String.format("Executando método TipoInvestimentoResource.create | valores: %s",entity.toString()));

        TipoInvestimento tipoInvestimento = tipoInvestimentoService.create(entity);

        return tipoInvestimento;
    }

    @Override
    @Operation(
            summary = "Recupera um tipo de investimento",
            description = "Método responsável para recuperar um tipo de investimento no sistema.",
            tags = { "tipoinvestimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TipoInvestimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public TipoInvestimento read(@Valid @RequestBody TipoInvestimento entity) throws Exception
    {
        log.info("Executado método TipoInvestimentoResource.read");
        log.debug(String.format("Executando método TipoInvestimentoResource.read | valores: %s",entity.toString()));

        TipoInvestimento tipoInvestimento = tipoInvestimentoService.read(entity);

        return tipoInvestimento;
    }

    @Override
    @Operation(
            summary = "Recupera um tipo de investimento baseado no identificador",
            description = "Método responsável para recuperar um tipo de investimento no sistema baseado no identificador.",
            tags = { "tipoinvestimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TipoInvestimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public TipoInvestimento readById(@PathVariable("id") Integer id) throws Exception
    {
        log.info("Executado método TipoInvestimentoResource.readById");
        log.debug(String.format("Executando método TipoInvestimentoResource.readById | valores: %d",id));

        TipoInvestimento tipoInvestimento = tipoInvestimentoService.readById(id);

        return tipoInvestimento;
    }

    @Override
    @Operation(
            summary = "Atualiza um tipo de investimento",
            description = "Método responsável para atualizar um tipo de investimento no sistema.",
            tags = { "tipoinvestimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TipoInvestimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public TipoInvestimento update(@Valid @RequestBody TipoInvestimento entity)
    {
        log.info("Executado método TipoInvestimentoResource.update");
        log.debug(String.format("Executando método TipoInvestimentoResource.update | valores: %s",entity.toString()));

        TipoInvestimento tipoInvestimento = tipoInvestimentoService.updateFull(entity);

        return tipoInvestimento;
    }

    @Override
    @Operation(
            summary = "Atualiza parte dos dados de um tipo de investimento",
            description = "Método responsável para atualizar parte dos dados de um tipo de investimento no sistema.",
            tags = { "tipoinvestimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TipoInvestimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public TipoInvestimento updatePart(@PathVariable("id") Integer id, @Valid @RequestBody TipoInvestimento entity) throws Exception
    {
        log.info("Executado método TipoInvestimentoResource.updatePart");
        log.debug(String.format("Executando método TipoInvestimentoResource.updatePart | valores: %d, %s",id,entity));

        TipoInvestimento tipoInvestimento = tipoInvestimentoService.updatePart(id, entity);

        return tipoInvestimento;
    }

    @Override
    @Operation(
            summary = "Atualiza todos os dados de um tipo de investimento",
            description = "Método responsável para atualizar todos os dados de um tipo de investimento no sistema.",
            tags = { "tipoinvestimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TipoInvestimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping("/{id}")
    public TipoInvestimento updateFull(@PathVariable("id") Integer id, @Valid @RequestBody TipoInvestimento entity)
    {
        log.info("Executado método TipoInvestimentoResource.updateFull");
        log.debug(String.format("Executando método TipoInvestimentoResource.updateFull | valores: %d, %s",id,entity));

        TipoInvestimento tipoInvestimento = tipoInvestimentoService.updateFull(id, entity);

        return tipoInvestimento;
    }

    @Override
    @Operation(
            summary = "Deleta um tipo de investimento com base no identificador",
            description = "Método responsável para deletar um tipo de investimento no sistema com base no identificador.",
            tags = { "tipoinvestimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TipoInvestimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id)
    {
        log.info("Executado método TipoInvestimentoResource.delete");
        log.debug(String.format("Executando método TipoInvestimentoResource.delete | valores: %d",id));

        tipoInvestimentoService.deleteById(id);
    }

    @Override
    @Operation(
            summary = "Deleta um tipo de investimento",
            description = "Método responsável para deletar um tipo de investimento no sistema.",
            tags = { "tipoinvestimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TipoInvestimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteByEntity(@Valid @RequestBody TipoInvestimento entity)
    {
        log.info("Executado método TipoInvestimentoResource.deleteByEntity");
        log.debug(String.format("Executando método TipoInvestimentoResource.deleteByEntity | valores: %s",entity.toString()));

        tipoInvestimentoService.delete(entity);
    }
}