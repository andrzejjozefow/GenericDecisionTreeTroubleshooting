package pl.decisiontree;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DecisionTree {

  private Branch rootNode;

  public static DecisionTree fromJson(final String treeInJson) {
    return Jsons.GSON.fromJson(treeInJson, DecisionTree.class);
  }

  public String toJson() {
    return Jsons.GSON.toJson(this);
  }

}
