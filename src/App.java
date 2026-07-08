import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        InventoryController controller = new InventoryController();

        List<LabSupply> labSupplies = new ArrayList<>();

        labSupplies.add(new LabSupply("In-202-102", "Sofia Cordero  ", 102));
        labSupplies.add(new LabSupply("In-206-106", "Carlos mendes", 106));
        labSupplies.add(new LabSupply("In-209-102", "Ana Torres", 70));
        labSupplies.add(new LabSupply("In-202-102", "Sofia Cordero", 102));
        labSupplies.add(new LabSupply("In-223-103", "david leon", 43));
        labSupplies.add(new LabSupply("in-243-121", "kevin Perez", 10));
        labSupplies.add(new LabSupply("In-256-124", "Fernando aucar", 22));
        labSupplies.add(new LabSupply("in-232-143", "ana Torres", 100));

        System.out.println("----METODO A-------");
        Set<LabSupply> labSupply = controller.filtrarAndSortSupplies(labSupplies, 20);
        for (LabSupply labSupply2 : labSupply) {
            System.out.println(labSupply2);
        }

        System.out.println("----Metodo B-----");
        Map<String, Set<String>> mapa = controller.gruparCodeByStock(labSupplies);

        for (Map.Entry<String, Set<String>> entry : mapa.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}
