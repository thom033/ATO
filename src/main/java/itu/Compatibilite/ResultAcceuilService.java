package itu.compatibilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultAcceuilService {

    private final ResultAcceuilRepository repository;

    @Autowired
    public ResultAcceuilService(ResultAcceuilRepository repository) {
        this.repository = repository;
    }

    public List<ResultAcceuil> getAllResults() {
        return repository.getResultAcceuils();
    }
}
