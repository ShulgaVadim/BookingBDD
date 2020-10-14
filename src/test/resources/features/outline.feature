Feature: Booking search
  Searching for different hotels on booking.com
  Scenario Outline: Searching for hotel
    Given User opens search page
    And Name of the hotel is <hotel>
    When User does search
    Then Hotel <resultsHotel> is on the first page
    And Hotel <resultsHotel> has <rating>
    Examples:
      |hotel           |resultsHotel          |rating|
      |"Marriott Minsk"|"Minsk Marriott Hotel"|"8.9" |
      |"Marriott Minsk"|"President Hotel"     |"9.0" |
      |"Marriott Minsk"|"Europe Hotel"        |"9.0" |




