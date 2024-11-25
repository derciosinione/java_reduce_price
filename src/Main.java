import java.util.*;


public class Main {
    private static final List<Integer> standardRange = List.of(60, 60, 53, 53, 53, 50, 50, 50, 47, 47, 47, 45, 45, 41, 41, 38, 38, 35, 35);
    private static final List<Integer> precoConfortRange = List.of(450, 450, 400, 400);
    private static final List<Integer> precoDeluxeRange = List.of(600, 500);

    public static Map<String, List<ClassConfortPrice>> prices = Map.of(
            ClasseConforto.STANDARD.name(), convertRangeToConfortPrice(standardRange),
            ClasseConforto.COMFORT.name(), convertRangeToConfortPrice(precoConfortRange),
            ClasseConforto.DELUXE.name(), convertRangeToConfortPrice(precoDeluxeRange)
    );

    public static void main(String[] args) {

        var classe = ClasseConforto.COMFORT;
        var desiredPrices = getPriceRange(classe.name());

        int ticketNumber = 2;

        var ticketsToBuy = getPrecoBase(desiredPrices, ticketNumber);

        var maxPrice = Collections.max(ticketsToBuy);

        var precoTotal = 0;

        precoTotal += maxPrice;

        precoTotal = precoTotal * ticketNumber;

        System.out.println(precoTotal);

        // TODO: Set the selected ticketsToBuy to available false in prices map

    }

    private static List<Long> getPriceRange(String className) {
        return prices.get(className)
                .stream()
                .filter(x->x.isAvailable)
                .map(x->x.price)
                .toList();
    }

    private static ArrayList<ClassConfortPrice> convertRangeToConfortPrice(List<Integer> priceRange) {
        return new ArrayList<>(priceRange.stream()
                .map(value -> new ClassConfortPrice(value, true))
                .toList());
    }

    private static List<Long> getPrecoBase(List<Long> precos, int numeroPassageiros) {
        int start = Math.max(precos.size() - numeroPassageiros, 0);
        return precos.stream().toList().subList(start, precos.size());
    }
}