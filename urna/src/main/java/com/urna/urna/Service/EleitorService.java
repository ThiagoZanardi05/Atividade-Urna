    package com.urna.urna.Service;

    import com.urna.urna.Entity.Eleitor;
    import com.urna.urna.Entity.enums.Status;
    import com.urna.urna.Repository.EleitorRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    @Service
    public class EleitorService {

        @Autowired
        private EleitorRepository eleitorRepository;

        public Eleitor saveEleitor(Eleitor eleitor) {
            if (eleitor.getEmail() == null || eleitor.getEmail().isEmpty()) {
                eleitor.setStatus(Status.PENDENTE);

            }if (eleitor.getCpf() == null || eleitor.getCpf().isEmpty()) {
                eleitor.setStatus(Status.PENDENTE);

            }
            return eleitorRepository.save(eleitor);
        }

    }
