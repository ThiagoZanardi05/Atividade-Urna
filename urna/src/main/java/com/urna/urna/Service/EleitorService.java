    package com.urna.urna.Service;

    import com.urna.urna.Entity.Eleitor;
    import com.urna.urna.Entity.enums.Status;
    import com.urna.urna.Repository.EleitorRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class EleitorService {

        @Autowired
        private EleitorRepository eleitorRepository;

        public Eleitor saveEleitor(Eleitor eleitor) {
            if (eleitor.getEmail() == null || eleitor.getEmail().isEmpty()) {
                eleitor.setStatus(Status.PENDENTE);

            }if (eleitor.getCpf() == null || eleitor.getCpf().isBlank()) {
                eleitor.setStatus(Status.PENDENTE);

            }else{
                eleitor.setStatus(Status.APTO);
            }
            return eleitorRepository.save(eleitor);
        }

        public List<Eleitor> findAll() {
            return eleitorRepository.findAll();
        }

        public void deleteEleitor(Eleitor eleitor) {
        eleitor.setStatus(Status.INATIVO);
        }
    }
