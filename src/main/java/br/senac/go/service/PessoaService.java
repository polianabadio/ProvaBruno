package br.senac.go.service;

import br.senac.go.interfaces.IService;
import br.senac.go.model.Pessoa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PessoaService implements IService<Pessoa, Integer> {
    @Override
    public Pessoa create(Pessoa entity) {
        log.info("Executado método PessoaService.create");
        log.debug(String.format("Executado método PessoaService.create | valores: %s",entity.toString() ) );
        return null;
    }

    @Override
    public Pessoa readById(Integer id) throws Exception {
        log.info("Executado método PessoaService.readById");
        log.debug(String.format("Executado método PessoaService.readById | valores: %d",id ) );
        return null;
    }

    @Override
    public Pessoa read(Pessoa entity) throws Exception {
        log.info("Executado método PessoaService.read");
        log.debug(String.format("Executado método PessoaService.read | valores: %s",entity.toString() ) );
        return null;
    }

    @Override
    public Pessoa updateFull(Pessoa entity) {
        log.info("Executado método PessoaService.updateFull");
        log.debug(String.format("Executado método PessoaService.updateFull | valores: %s",entity.toString() ) );
        return null;
    }

    @Override
    public Pessoa updatePart(Integer id, Pessoa entity) throws Exception {
        log.info("Executado método PessoaService.updatePart");
        log.debug(String.format("Executado método PessoaService.updatePart | valores: %d %s",id ,entity.toString() ) );
        return null;
    }

    @Override
    public Pessoa updateFull(Integer id, Pessoa entity) {
        log.info("Executado método PessoaService.updateFull");
        log.debug(String.format("Executado método PessoaService.updateFull | valores: %d %s",id ,entity.toString() ) );
        return null;
    }

    @Override
    public Pessoa deleteById(Integer id) {
        log.info("Executado método PessoaService.deleteById");
        log.debug(String.format("Executado método PessoaService.deleteById | valores: %d",id ) );
        return null;
    }

    @Override
    public Pessoa delete(Pessoa entity) {
        log.info("Executado método PessoaService.delete");
        log.debug(String.format("Executado método PessoaService.delete | valores: %s",entity.toString() ) );
        return null;
    }
}
