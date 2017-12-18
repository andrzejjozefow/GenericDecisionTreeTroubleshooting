package pl.decisiontree;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.SneakyThrows;
import org.junit.Test;

public class DecisionTreeApplicationTest {

  @Test
  public void shouldConvertTreeToJson(){

    Branch podlaczWtyczke = new Leaf("Podlacz wtyczke!");
    Branch pomocTechniczna = new Leaf("Skontaktuj sie z pomoca techniczna");

    Branch czyPodlaczylesDoPradu = new YesNoBranch("Czy podlaczyles do prądu", pomocTechniczna, podlaczWtyczke);

    Branch zamknijKlape = new Leaf("Zamknij klapę!");
    Branch czyZamknalesKlape = new YesNoBranch("Czy zamknałes klape", czyPodlaczylesDoPradu, zamknijKlape);

    DecisionTree zepsutaPralkaTree = new DecisionTree(czyZamknalesKlape);

    String decissionTreeInJson = zepsutaPralkaTree.toJson();

    System.out.println("Decision tree json:" + decissionTreeInJson);

  }

  @Test
  @SneakyThrows(IOException.class)
  public void shouldLoadTreeFromJson(){

    String treeInJson = new String(Files.readAllBytes(Paths.get("src/test/resources/exampleTree.json")));

    DecisionTree decisionTree = DecisionTree.fromJson(treeInJson);

    System.out.println("Decision tree object:" + decisionTree);
  }

}
