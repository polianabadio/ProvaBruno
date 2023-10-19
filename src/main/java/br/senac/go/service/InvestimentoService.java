package br.senac.go.service;

import br.senac.go.interfaces.IService;
import br.senac.go.model.Investimento;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InvestimentoService implements IService<Investimento, Integer> {
    @Override
    public Investimento create(Investimento entity) {
        log.info("Executado método InvestimentoService.create");
        log.debug(String.format("Executado método InvestimentoService.create | valores: %s",entity.toString() ) );
        return null;
    }

    @Override
    public Investimento readById(Integer id) throws Exception {
        log.info("Executado método InvestimentoService.readById");
        log.debug(String.format("Executado método InvestimentoService.readById | valores: %d",id ) );
        return null;
    }

    @Override
    public Investimento read(Investimento entity) throws Exception {
        log.info("Executado método InvestimentoService.read");
        log.debug(String.format("Executado método InvestimentoService.read | valores: %s",entity.toString() ) );
        return null;
    }

    @Override
    public Investimento updateFull(Investimento entity) {
        log.info("Executado método InvestimentoService.updateFull");
        log.debug(String.format("Executado método InvestimentoService.updateFull | valores: %s",entity.toString() ) );
        return null;
    }

    @Override
    public Investimento updatePart(Integer id, Investimento entity) throws Exception {
        log.info("Executado método InvestimentoService.updatePart");
        log.debug(String.format("Executado método InvestimentoService.updatePart | valores: %d %s",id ,entity.toString() ) );
        return null;
    }

    @Override
    public Investimento updateFull(Integer id, Investimento entity) {
        log.info("Executado método InvestimentoService.updateFull");
        log.debug(String.format("Executado método InvestimentoService.updateFull | valores: %d %s",id ,entity.toString() ) );
        return null;
    }

    @Override
    public Investimento deleteById(Integer id) {
        log.info("Executado método InvestimentoService.deleteById");
        log.debug(String.format("Executado método InvestimentoService.deleteById | valores: %d",id ) );
        return null;
    }

    @Override
    public Investimento delete(Investimento entity) {
        log.info("Executado método InvestimentoService.delete");
        log.debug(String.format("Executado método InvestimentoService.delete | valores: %s",entity.toString() ) );
        return null;
    }
}
