package edu.ieselgrao.javadoc;
import java.time.LocalDate;
import static edu.ieselgrao.javadoc.UniverseException.*;

/**
 * Define planetas y sus propiedades.
 * Los planetas se usan como componentes de sistemas solares.
 */
public class Planet {

    // Constants for minimum values
    private static final double MIN_MASS = 5.97e22;
    private static final double MIN_RADIUS = 500;

    // Attributes

    /** Nombre del planeta. */
    private String name;

    /** Número de lunas del planeta. */
    private int numberOfMoons;

    /** Masa del planeta. */
    private double mass;

    /** Radio del planeta. */
    private double radius;

    /** Gravedad del planeta. */
    private double gravity;

    /** Fecha de la última medición del albedo. */
    private LocalDate lastAlbedoMeasurement;

    /** Indica si el planeta tiene anillos. */
    private boolean hasRings;

    /** Atmósfera del planeta. */
    private Atmosphere atmosphere;

    /** Tipo de planeta. */
    private PlanetType type;

    // Basic constructor

    /**
     * Constructor completo.
     * @param name.
     * @param numberOfMoons.
     * @param mass.
     * @param radius.
     * @param gravity.
     * @param lastAlbedoMeasurement.
     * @param hasRings.
     * @param type.
     */
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings, PlanetType type) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        setType(type);

        atmosphere = null;
    }

    // Detailed constructor with atmosphere

    /**
     * Constructor completo con atmósfera.
     * @param name.
     * @param numberOfMoons.
     * @param mass.
     * @param radius.
     * @param gravity.
     * @param lastAlbedoMeasurement.
     * @param hasRings.
     * @param type.
     * @param composition.
     * @param lastObservation.
     * @param airQuality.
     * @param pressure.
     * @param density.
     * @param hasClouds.
     */
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings, PlanetType type, String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        setType(type);

        try {
            setAtmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
        } catch (UniverseException e) {
            this.atmosphere = null;
        }
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    /**
     * @param name el nombre del planeta, ni nulo ni vacío.
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new UniverseException(INVALID_PLANET_NAME);
        }
        this.name = name;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    /**
     * @param numberOfMoons el número de lunas, mayor o igual a 0.
     */
    public void setNumberOfMoons(int numberOfMoons) {
        if (numberOfMoons < 0) {
            throw new UniverseException(INVALID_NUMBER_OF_MOONS);
        }
        this.numberOfMoons = numberOfMoons;
    }

    public double getMass() {
        return mass;
    }

    /**
     * @param mass la masa del planeta, mayor que el mínimo marcado.
     */
    public void setMass(double mass) {
        if (mass < MIN_MASS) {
            throw new UniverseException(INVALID_MASS);
        }
        this.mass = mass;
    }

    public double getRadius() {
        return radius;
    }

    /**
     * @param radius el radio del planeta, mayor que el mínimo marcado.
     */
    public void setRadius(double radius) {
        if (radius < MIN_RADIUS) {
            throw new UniverseException(INVALID_PLANET_RADIUS);
        }
        this.radius = radius;
    }

    public double getGravity() {
        return gravity;
    }

    /**
     * @param gravity la gravedad del planeta, valor positivo.
     */
    public void setGravity(double gravity) {
        if (gravity <= 0) {
            throw new UniverseException(INVALID_GRAVITY);
        }
        this.gravity = gravity;
    }

    public LocalDate getLastAlbedoMeasurement() {
        return lastAlbedoMeasurement;
    }

    /**
     * @param lastAlbedoMeasurement la última medición del albedo, no nula y anterior a la fecha actual.
     */
    public void setLastAlbedoMeasurement(LocalDate lastAlbedoMeasurement) {
        if (lastAlbedoMeasurement == null || lastAlbedoMeasurement.isAfter(LocalDate.now())) {
            throw new UniverseException(INVALID_LAST_ALBEDO_MEASUREMENT);
        }
        this.lastAlbedoMeasurement = lastAlbedoMeasurement;
    }

    public boolean hasRings() {
        return hasRings;
    }

    /**
     * @param hasRings indica si el planeta tiene anillos.
     */
    public void setHasRings(boolean hasRings) {
        this.hasRings = hasRings;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    /**
     * @param composition la composición química de la atmósfera.
     * @param lastObservation la fecha de la última observación.
     * @param airQuality la calidad del aire (0 - 100).
     * @param pressure la presión atmosférica.
     * @param density la densidad de la atmósfera.
     * @param hasClouds indica si la atmósfera tiene nubes.
     */
    public void setAtmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        atmosphere = new Atmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
    }

    public PlanetType getType() {
        return type;
    }

    /**
     * @param type el tipo de planeta, no nulo.
     */
    public void setType(PlanetType type) {
        if (type == null) {
            throw new UniverseException(INVALID_PLANET_TYPE);
        }
        this.type = type;
    }
}