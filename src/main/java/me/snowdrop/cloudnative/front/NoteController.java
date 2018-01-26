package me.snowdrop.cloudnative.front;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("note")
public class NoteController {

    private final NoteGateway noteGateway;

    public NoteController(NoteGateway noteGateway) {
        this.noteGateway = noteGateway;
    }

    @GetMapping
    public List<Note> all() {
        return noteGateway.all();
    }

    @DeleteMapping(value = "/{id}")
    public DefaultResult delete(@PathVariable("id") int id) {
        noteGateway.delete(id);

        return DefaultResult.INSTANCE;
    }

    private static class DefaultResult {

        private final String result = "OK";

        public String getResult() {
            return result;
        }

        private static DefaultResult INSTANCE = new DefaultResult();

        private DefaultResult() {}
    }
}
