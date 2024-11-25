/**
 * Enumeração com as várias classes de conforto que a companhia
 * suporta (também podia estar configurada num ficheiro, mas
 * assim simplifica mais o sistema).
 * Cada classe de conforto tem associadas as reserva que suporta
 */
public enum ClasseConforto {
    STANDARD(ESTAirways.ECONOMICA, ESTAirways.BASIC),
    COMFORT(ESTAirways.BUSINESS),
    DELUXE(ESTAirways.EXECUTIVE);


    private String[] tipoReservas;

    ClasseConforto(String... r) {
        tipoReservas = r;
    }

    public String[] getReservaAssociadas() {
        return tipoReservas;
    }
}
