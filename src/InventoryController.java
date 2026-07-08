import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class InventoryController {
  public Set<LabSupply> filtrarAndSortSupplies(List<LabSupply> supplies, int minimunStock) {
    Set<LabSupply> resultado = new TreeSet<>((l1, l2) -> {
      int camS = Integer.compare(l2.getStock(), l1.getStock());
      if (camS != 0) {
        return camS;
      }
      int camC = l1.getCode().compareToIgnoreCase(l2.getCode());
      if (camC != 0) {
        return camC;
      }
      return 0;

    });
    for (LabSupply labSupply : supplies) {
      if (labSupply.getStock() >= minimunStock) {
        resultado.add(labSupply);
      }
    }
    return resultado;

  }

  public Map<String, Set<String>> gruparCodeByStock(List<LabSupply> supplies) {
    Map<String, Set<String>> mapa = new TreeMap<>();

    Set<String> high = new LinkedHashSet<>();
    Set<String> medium = new LinkedHashSet<>();
    Set<String> low = new LinkedHashSet<>();

    mapa.put("HIGH", high);
    mapa.put("MEDIUM", medium);
    mapa.put("LOW", low);
    for (LabSupply labSupply : supplies) {
      String orden = labSupply.getCode().split(" ")[0];
      if (labSupply.getStock() >= 50) {
        high.add(orden);
      } else if (labSupply.getStock() <= 20) {
        medium.add(orden);
      } else {
        low.add(orden);
      }
    }
    return mapa;
  }
}
