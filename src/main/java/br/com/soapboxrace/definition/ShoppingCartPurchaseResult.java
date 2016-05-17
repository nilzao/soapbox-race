package br.com.soapboxrace.definition;

public interface ShoppingCartPurchaseResult {
	String aFail_maxallowed = "Fail_MaxAllowedPurchasesForThisProduct";
	String aFail_insufficientperfinventory = "Fail_InsufficientPerformancePartInventory";
	String aFail_boosttransdisabled = "Fail_BoostTransactionsAreDisabled";
	String aFail_lockedproduct = "Fail_LockedProductNotAccessibleToThisUser";
	String aFail_personalevelerror = "Fail_PersonaNotRightLevel";
	String aFail_itemnotavail = "Fail_ItemNotAvailableStandalone";
	String aFail_invalidperfupgrade = "Fail_InvalidPerformanceUpgrade";
	String aFail_maxstackorrental = "Fail_MaxStackOrRentalLimit";
	String aFail_insufficientcarslots = "Fail_InsufficientCarSlots";
	String aFail_insufficientfunds = "Fail_InsufficientFunds";
	String aFail_invalidbasket = "Fail_InvalidBasket";
	String aSuccess = "Success";
}