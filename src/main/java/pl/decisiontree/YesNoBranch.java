package pl.decisiontree;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class YesNoBranch implements Branch {

  private String question;
  private Branch onYes;
  private Branch onNo;

  @Override
  public boolean isLeaf() {
    return false;
  }
}
