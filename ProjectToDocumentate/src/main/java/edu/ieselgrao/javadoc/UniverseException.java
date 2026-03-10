package edu.ieselgrao.javadoc;

/**
 * Excepcion utilizada en el proyecto para indicar errores relacionados
 * con planetas, atmosferas y sistemas solares.
 */
public class UniverseException extends IllegalArgumentException {

    // Constants for error messages

    /** Mensaje de error cuando el nombre del planeta es nulo o vacio. */
    public static final String INVALID_PLANET_NAME = "[ERROR] Name cannot be null or empty";

    /** Mensaje de error cuando el numero de lunas es negativo. */
    public static final String INVALID_NUMBER_OF_MOONS = "[ERROR] Number of moons cannot be negative";

    /** Mensaje de error cuando la masa del planeta es demasiado pequena. */
    public static final String INVALID_MASS = "[ERROR] Mass cannot be less than 10e23 kg";

    /** Mensaje de error cuando el radio del planeta es demasiado pequeno. */
    public static final String INVALID_PLANET_RADIUS = "[ERROR] Radius cannot be less than 500 km";

    /** Mensaje de error cuando la gravedad no es valida. */
    public static final String INVALID_GRAVITY = "[ERROR] Gravity cannot be negative or zero";

    /** Mensaje de error cuando la fecha de medicion del albedo no es valida. */
    public static final String INVALID_LAST_ALBEDO_MEASUREMENT = "[ERROR] Last albedo measurement cannot be null or in the future";

    /** Mensaje de error cuando el tipo de planeta es nulo. */
    public static final String INVALID_PLANET_TYPE = "[ERROR] Invalid planet type";

    /** Mensaje de error cuando la composicion de la atmosfera no es valida. */
    public static final String INVALID_COMPOSITION = "[ERROR] Composition cannot be null or empty";

    /** Mensaje de error cuando la fecha de ultima observacion no es valida. */
    public static final String INVALID_LAST_OBSERVATION = "[ERROR] Last observation cannot be null or in the future";

    /** Mensaje de error cuando la presion es negativa. */
    public static final String INVALID_PRESSURE = "[ERROR] Pressure cannot be negative";

    /** Mensaje de error cuando la densidad es negativa. */
    public static final String INVALID_DENSITY = "[ERROR] Density cannot be negative";

    /** Mensaje de error cuando el nombre del sistema solar no es valido. */
    public static final String INVALID_SOLAR_SYSTEM_NAME = "[ERROR] Name cannot be null, contain only spaces or have less than 3 characters";

    /** Mensaje de error cuando el numero de estrellas es menor que 1. */
    public static final String INVALID_NUMBER_OF_STARS = "[ERROR] Number of stars cannot be less than 1";

    /** Mensaje de error cuando el radio del sistema solar no es valido. */
    public static final String INVALID_SOLAR_SYSTEM_RADIUS = "[ERROR] Radius cannot be less or equal to 0";

    /** Mensaje de error cuando la fecha de registro no es valida. */
    public static final String INVALID_REGISTRATION_DATE = "[ERROR] Registration date cannot be null or in the future";

    /** Mensaje de error cuando la fecha del ultimo planeta anadido no es valida. */
    public static final String INVALID_LAST_PLANET_ADDED = "[ERROR] Last planet date added cannot be in the future";

    /** Mensaje de error cuando se supera el numero maximo de planetas. */
    public static final String INVALID_MAX_PLANETS = "[ERROR] Maximum number of planets reached";

    /** Mensaje de error cuando el planeta es nulo. */
    public static final String PLANET_NULL = "[ERROR] Planet cannot be null";

    /** Mensaje de error cuando el planeta ya existe. */
    public static final String PLANET_ALREADY_EXISTS = "[ERROR] This planet already exists";

    /** Mensaje de error cuando el planeta no existe. */
    public static final String PLANET_NOT_FOUND = "[ERROR] This planet does not exist";

    /**
     * Crea una excepcion con el mensaje del error.
     * @param message mensaje del error
     */
    public UniverseException(String message) {
        super(message);
    }
}