import java.util.ArrayList;

public class Presentation {

  private ArrayList<Slide> slideList;
  private ArrayList<Meta> metaList;

  private Defaults presentationDefault;

  public Presentation(Defaults programDefaults) {
    this.slideList = new ArrayList<Slide>();
    this.metaList = new ArrayList<Meta>();
    this.presentationDefault = programDefaults;
  }

  public void addSlide(Slide newSlide) { this.slideList.add(newSlide); }

  public Slide getSlideByID(String id) {
    for (Slide currentSlide : slideList) {
      if (currentSlide.getId().equals(id)) {
        return currentSlide;
      }
    }

    return null;
  }

  public boolean checkForSlide(String id) {
    for (Slide currentSlide : slideList) {
      if (currentSlide.getId().equals(id)) {
        return true;
      }
    }

    return false;
  }

  public void addMeta(Meta newMeta) { this.metaList.add(newMeta); }

  public String getMetaByName(String key) {
    for(Meta currentMeta : metaList) {
      if(currentMeta.getKeyword().equals(key)) {
        return currentMeta.getValue();
      }
    }
    return "";
  }

  public void setDefaults(Colors color, TextStyle style) {
    this.presentationDefault.setDefaultStyle(style);
    this.presentationDefault.setDefaultColors(color);
  }

  public void setDefaults(Colors color) {
    this.presentationDefault.setDefaultColors(color);
  }

  public void setDefaults(TextStyle style) {
    this.presentationDefault.setDefaultStyle(style);
  }

}