package exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {

        super("Il record con id " + id + " non è stato trovato!");
    }

    public NotFoundException(String partecipazioneNonTrovata) {


    }
}
