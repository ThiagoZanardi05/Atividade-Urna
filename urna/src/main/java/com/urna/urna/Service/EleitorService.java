    package com.urna.urna.Service;

    import com.urna.urna.Entity.Eleitor;
    import com.urna.urna.Entity.enums.Status;
    import com.urna.urna.Repository.EleitorRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class EleitorService {

        @Autowired
        private EleitorRepository eleitorRepository;

        public Eleitor saveEleitor(Eleitor eleitor) {
            if (eleitor.getCpf() == null || eleitor.getCpf().isBlank()) {
                eleitor.setStatus(Status.PENDENTE);
            }

            if (eleitor.getEmail() == null || eleitor.getEmail().isEmpty()) {
                eleitor.setStatus(Status.PENDENTE);
            }
            else{
                eleitor.setStatus(Status.APTO);
            }
            return eleitorRepository.save(eleitor);
        }

        public List<Eleitor> findAll() {
            return eleitorRepository.findAll();
        }

        public void setEleitorInativo(Long id) {
            Optional<Eleitor> eleitorOp = eleitorRepository.findById(id);

            if (eleitorOp.isPresent()) {
                Eleitor eleitor = eleitorOp.get();
                eleitor.setStatus(Status.INATIVO);
                eleitorRepository.save(eleitor);
            } else {
                throw new RuntimeException("Eleitor não existe");
            }
        }
        public List<Eleitor> listarEleitoresAptos() {
            return eleitorRepository.findByStatus(Status.APTO);
        }

        public Eleitor updateEleitor(Long id, Eleitor novosDadosEleitor) {
            Optional<Eleitor> eleitorExistenteOp = eleitorRepository.findById(id);

            if (eleitorExistenteOp.isPresent()) {
                Eleitor eleitorExistente = eleitorExistenteOp.get();

                if (eleitorExistente.getStatus() == Status.INATIVO) {
                    novosDadosEleitor.setStatus(Status.INATIVO);
                } else {
                    if (novosDadosEleitor.getCpf() == null || novosDadosEleitor.getCpf().isBlank() ||
                            novosDadosEleitor.getEmail() == null || novosDadosEleitor.getEmail().isEmpty()) {
                        novosDadosEleitor.setStatus(Status.PENDENTE);
                    } else {
                        novosDadosEleitor.setStatus(Status.APTO);
                    }
                }

                eleitorExistente.setProfissao(novosDadosEleitor.getProfissao());
                eleitorExistente.setTelefoneCelular(novosDadosEleitor.getTelefoneCelular());
                eleitorExistente.setTelefoneFixo(novosDadosEleitor.getTelefoneFixo());
                eleitorExistente.setEmail(novosDadosEleitor.getEmail());
                eleitorExistente.setCpf(novosDadosEleitor.getCpf());

                return eleitorRepository.save(eleitorExistente);
            } else {
                throw new RuntimeException("Eleitor não encontrado");
            }
        }
    }


