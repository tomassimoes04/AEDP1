package System;

/**
 ˚ @author Tomás Martinho Simões (66152) tma.simoes@campus.fct.unl.pt
 ˚ @author Lourenço Calhau (65524) l.calhau@campus.fct.unl.pt
 */

import dataStructures.Iterator;
import java.io.Serializable;

public interface Work extends Serializable {
  /**
   * returns the work's ID
   * @return Work's ID
   */
  String getId();

  /**
   * returns the work's name
   * @return Work's name
   */
  String getName();

  /**
   * returns the work's year
   * @return Work's year
   */
  int getYear();

  /**
   * returns the last value the work has been bought for
   * @return Work's last buy value
   */
  int getLastBuyValue();

  /**
   * returns the last buyer's login
   * @return Buyer's login
   */
  String getBuyerLogin();

  /**
   * returns the last buyer's name
   * @return Buyer's name
   */
  String getBuyerName();

  /**
   * Checks if the work was sold
   * @return
   */
  boolean wasSold();

  int highestBuyValue();

  String getArtistLogin();

  String getArtistName();

  void setMinimumValue(int value);

  int getMinimumValue();

  void notSold();

  void sold();

  void addBid(Bid bid);

  boolean hasBid(String auctionId);

  void setLastBuyValue(String auctionId);

  void eraseBids(String auctionId);

  Iterator<Bid> listBids(String auctionId);

  void setLastBuyer(User winner, int value);

  Bid getHighestBid(String auctionId);
}
