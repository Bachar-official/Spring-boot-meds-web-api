package payroll;

class DrugNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    DrugNotFoundException(Long id) {
        super("Could not found drug number " + id);
    }
}
