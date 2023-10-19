package br.senac.go.service;

import br.senac.go.interfaces.IService;
import br.senac.go.model.TipoConta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TipoContaService implements IService<TipoConta, Integer> {
    @Override
    public TipoConta create(TipoConta entity) {
        log.info("Executado método TipoContaService.create");
        log.debug(String.format("Executado método TipoContaService.create | valores: %s",entity.toString() ) );
        return null;
    }

    @Override
    public TipoConta readById(Integer id) throws Exception {
        log.info("Executado método TipoContaService.readById");
        log.debug(String.format("Executado método TipoContaService.readById | valores: %d",id ) );
        return null;
    }

    @Override
    public TipoConta read(TipoConta entity) throws Exception {
        log.info("Executado método TipoContaService.read");
        log.debug(String.format("Executado método TipoContaService.read | valores: %s",entity.toString() ) );
        return null;
    }

    @Override
    public TipoConta updateFull(TipoConta entity) {
        log.info("Executado método TipoContaService.updateFull");
        log.debug(String.format("Executado método TipoContaService.updateFull | valores: %s",entity.toString() ) );
        return null;
    }

    @Override
    public TipoConta updatePart(Integer id, TipoConta entity) throws Exception {
        log.info("Executado método TipoContaService.updatePart");
        log.debug(String.format("Executado método TipoContaService.updatePart | valores: %d %s",id ,entity.toString() ) );
        return null;
    }

    @Override
    public TipoConta updateFull(Integer id, TipoConta entity) {
        log.info("Executado método TipoContaService.updateFull");
        log.debug(String.format("Executado método TipoContaService.updateFull | valores: %d %s",id ,entity.toString() ) );
        return null;
    }

    @Override
    public TipoConta deleteById(Integer id) {
        log.info("Executado método TipoContaService.deleteById");
        log.debug(String.format("Executado método TipoContaService.deleteById | valores: %d",id ) );
        return null;
    }

    @Override
    public TipoConta delete(TipoConta entity) {
        log.info("Executado método TipoContaService.delete");
        log.debug(String.format("Executado método TipoContaService.delete | valores: %s",entity.toString() ) );
        return null;
    }
}

