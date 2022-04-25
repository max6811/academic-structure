package maxcmartinez.academic_structure.academicstructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException
//checked
// unchecked  = tiempo de ejecucion
{
    public NotFoundException(String resourceName, String uuid) {
        super(String.format("Elment not found: %s - UUID: %s", resourceName, uuid));
    }
}
