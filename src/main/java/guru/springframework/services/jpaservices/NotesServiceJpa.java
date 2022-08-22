package guru.springframework.services.jpaservices;

import guru.springframework.domain.Notes;
import guru.springframework.repositories.NotesRepository;
import guru.springframework.services.NotesService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class NotesServiceJpa implements NotesService {

    private final NotesRepository notesRepository;

    public NotesServiceJpa(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public Set<Notes> findAll() {
        Set<Notes> notes = new HashSet<>();
        notesRepository.findAll().forEach(note -> {
            notes.add(note);
        });
        return notes;
    }

    @Override
    public Notes findById(Long aLong) {
        return notesRepository.findById(aLong).get();
    }

    @Override
    public Notes save(Notes obj) {
        return notesRepository.save(obj);
    }

    @Override
    public void delete(Notes obj) {
        notesRepository.delete(obj);

    }

    @Override
    public void deleteById(Long aLong) {
        notesRepository.deleteById(aLong);
    }
}
