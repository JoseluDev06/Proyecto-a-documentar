package edu.ieselgrao.javadoc;
import java.time.LocalDate;

import static edu.ieselgrao.javadoc.UniverseException.*;

/**
*Define atmosferas y sus propiedades.
*Las atmosferas se usan como atributos en instancias de la clase planeta.
 *@author Alvaro Ruiz
 */
public class Atmosphere {

    // Attributes
    /** Composición química de la atmósfera. */
    private String composition;

    /** Fecha de la última observación de la atmósfera. */
    private LocalDate lastObservation;

    /** Calidad del aire en una escala de 0 a 100. */
    private int airQuality;

    /** Presión atmosférica. */
    private double pressure;

    /** Densidad de la atmósfera. */
    private double density;

    /** Indica si la atmósfera contiene nubes. */
    private boolean hasClouds;

    // Constructor

    /**
     *Constructor completo.
     @param composition composición química de la atmósfera
     @param lastObservation fecha de la última observación
     @param airQuality calidad del aire (0-100)
     @param pressure presión atmosférica
     @param density densidad de la atmósfera
     @param hasClouds indica si hay nubes
     */
    public Atmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setComposition(composition);
        setLastObservation(lastObservation);
        setAirQuality(airQuality);
        setPressure(pressure);
        setDensity(density);
        setHasClouds(hasClouds);
    }

    // Getters and setters
    public String getComposition() {
        return composition;
    }

    /**
     *
     * @param composition la composicion quimica, no es nula y solo se compone de letras, numeros y comas.
     */
    public void setComposition(String composition) {
        if (composition == null || composition.trim().isEmpty() || !composition.matches("[a-zA-Z0-9, ]+")) {
            throw new UniverseException(INVALID_COMPOSITION);
        }
        this.composition = composition;
    }

    public LocalDate getLastObservation() {
        return lastObservation;
    }

    /**
     *
     * @param lastObservation la ultima observacion, no es nula y es anterior a la fecha actual.
     */
    public void setLastObservation(LocalDate lastObservation) {
        // LocalDate.now() can be setted
        if (lastObservation == null || lastObservation.isAfter(LocalDate.now())) {
            throw new UniverseException(INVALID_LAST_OBSERVATION);
        }
        this.lastObservation = lastObservation;
    }

    public int getAirQuality() {
        return airQuality;
    }

    /**
     *
     * @param airQuality la calidad del aire (0 - 100).
     */
    public void setAirQuality(int airQuality) {
        // Adjust to range [0, 100]
        if (airQuality < 0) {
            this.airQuality = 0;
        } else if (airQuality > 100) {
            this.airQuality = 100;
        } else {
            this.airQuality = airQuality;
        }
    }


    public double getPressure() {
        return pressure;
    }

    /**
     *
     * @param pressure la presion, valor positivo.
     */
    public void setPressure(double pressure) {
        if (pressure < 0) {
            throw new UniverseException(INVALID_PRESSURE);
        }
        this.pressure = pressure;
    }

    public double getDensity() {
        return density;
    }

    /**
     *
     * @param density la densidad, valor positivo.
     */
    public void setDensity(double density) {
        if (density < 0) {
            throw new UniverseException(INVALID_DENSITY);
        }
        this.density = density;
    }
    /** @return true si la atmósfera tiene nubes */
    public boolean hasClouds() {
        return hasClouds;
    }

    /**
     * @param hasClouds indica si la atmósfera tiene nubes
     */
    public void setHasClouds(boolean hasClouds) {
        this.hasClouds = hasClouds;
    }

}
