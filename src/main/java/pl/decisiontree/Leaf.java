package pl.decisiontree;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Leaf implements Branch {

  private String answer;

  @Override
  public boolean isLeaf() {
    return true;
  }
}
