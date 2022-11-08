class Seller {
   private int iphonePrice;
   private int galaxyPrice;

   public void setIphonePrice(int iphonePrice) {
      this.iphonePrice = iphonePrice;
   }

   public double getGalaxyPrice() {
      return galaxyPrice * 0.8;
   }

   public void setGalaxyPrice(int galaxyPrice) {
      this.galaxyPrice = galaxyPrice;
   }

   public double getIphonePrice() {
      return iphonePrice * 0.9;
   }
}
