package com.onbis.Pages;

import com.onbis.Helper.Config;
import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PartnerSoleProprietorshipRegistrationPage extends PageObject {
    private PartnerSoleProprietorshipRegistrationPage partnerSoleProprietorshipRegistrationPage;

    public PartnerSoleProprietorshipRegistrationPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(xpath = "//input[@type='search']")
//    WebElement primaryActivityType;

    @FindBy(xpath = "//div[contains(@class,'appAttributeLookup appAutoComplete')]//input[1]")
    WebElement primaryActivityType;

//    @FindBy(xpath = "//ul[@id='vs1__listbox']/li[1]/span[2]")
//    WebElement primaryActivityTypeTransportation;

    @FindBy(linkText = "Truck transportation [NAICS 484]")
    private WebElement primaryActivityTypeTransportation;

    @FindBy(linkText = "Ambulatory health care services [NAICS 621]")
    private WebElement primaryActivityTypeAmbulatoryHealthCareServices;

    @FindBy(xpath = "//span[contains(@class,'select2-selection select2-selection--single')]//span")
    WebElement governingJurisdictionOptionList;
    @FindBy(xpath = "(//span[@class='select2-selection__rendered']//span)[2]")
    WebElement provinceOptionList;
    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement governingJurisdictionSearchArea;
    @FindBy(xpath = "//div[@class='appAttrLabelBox appCompanyName']/following-sibling::input[1]")
    WebElement proposedBusinessNameField;
    @FindBy(xpath = "//input[contains(@id, '-Email')]")
    WebElement officialEmailValue;
    @FindBy(xpath = "//input[contains(@id,'-ConfirmEmail')]")
    WebElement confirmOfficialEmailValue;
    @FindBy(xpath = "//span[text()='Authorization']")
    WebElement authorizationTabLink;
    @FindBy(xpath = "//label[contains(@for,'-DeclarationYn')]")
    WebElement declarationCheckBox;
    @FindBy(xpath = "//label[contains(@for,'-principlePlaceOfBusinessExistsYnY')]")
    WebElement placeOfBusinessYes;
    @FindBy(xpath = "//span[contains(text(),'Save and Continue')]")
    WebElement saveAndContinue;
//    @FindBy(xpath = "//span[text()='Business Name']")
    @FindBy(xpath = "//a[@class='rovingIndex keepInteractiveOnSubmit']//span")  //span[@class='appSpaces1 appLines1']
    WebElement buttonBusinessName;
    @FindBy(xpath = "//span[text()='Owner']")
    WebElement buttonOwner;
    @FindBy(xpath = "//span[text()='Authorization']")
    WebElement buttonAuthorization;
    @FindBy(xpath = "//span[text()='Review']")
    WebElement buttonReview;


    @FindBy(css = "form#viewInstanceForm>div:nth-of-type(2)>div>div>div>div:nth-of-type(3)>div:nth-of-type(3)>div>div:nth-of-type(2)>button>span:nth-of-type(2)>span")
    WebElement saveAndContinueAddress;
    @FindBy(xpath = "//span[text()='Address']")
    WebElement fileArticlesOfAmalgamationAddress;
    @FindBy(xpath = "//span[text()='Edit']")
    WebElement fileArticlesOfAmalgamationAddressEdit;

    @FindBy(xpath = "//div[@class='appAttrLabelBox appCompanyName']/following-sibling::div[1]")
    WebElement getBusinessName;

    @FindBy(xpath = "//span[contains(text(),'Save and Continue')]")
    WebElement saveAndContinueAmendRegistration;
    @FindBy(xpath = "//button[contains(@class,'appButton appRepeaterAdd')]")
    WebElement amendBusinessAddress;
    @FindBy(xpath = "//label[contains(@for,'-DeclarationYn')]")
    WebElement accuracyChekBox;
    @FindBy(xpath = "//span[text()='Filings']")
    WebElement filingsOption;
    @FindBy(xpath = "//span[text()='Amendment of a Business Name Registration for a Corporation']")
    WebElement amendmentBusinessNameRegistrationCorporation;
    @FindBy(xpath = "//span[text()='Business Name Registration for a Corporation']")
    WebElement amendmentBusinessNameRegistrationCorporation1;
    @FindBy(xpath = "//span[text()='Amendment of a Firm Name Registration for an Ontario Limited Liability Partnership']")
    WebElement amendmentBusinessNameRegistrationCorporation2;
    @FindBy(xpath = "//span[text()='Amendment of a Business Name Registration for a Partnership']")
    WebElement amendmentRegistrationOfAFirmNameForAGeneralPartnership;

    @FindBy(xpath = "//span[text()='BNA - New Registration of an Ontario Limited Liability Partnership']")
    WebElement amendmentBusinessNameRegistrationCorporation3;

    @FindBy(xpath = "//div[@class='appFilingDetailObject']//div[1]")
    WebElement bCAArticlesOfIncorporation;

    @FindBy(xpath = "//button[@class='appMenu appSubMenuName']")
    WebElement requestSearchProductsMenu;
    @FindBy(xpath = "//span[text()='Request Profile Report']")
    WebElement requestProfileReport;
    @FindBy(xpath = "//label[text()='Current Report']")
    WebElement currentReport;


    //span[text()='Business Name Registration for a Corporation']
    //span[text()='Amendment of a Business Name Registration for a Corporation']
    @FindBy(xpath = "/html/body/div[1]/div/div[6]/div/div/div[1]/div/form/div/div/div[1]/div/div/div[4]/div/div[5]/div/button/span[3]")
    WebElement adminMenu;
    @FindBy(xpath = "//span[text()='Change Entity Status']")
    WebElement changeEntityStatusMenuOption;


    @FindBy(xpath = "//span[text()='Make Changes']")
    WebElement makeChangesMenu;
    @FindBy(xpath = "(//span[@class='appReceiveFocus'])[3]")
    WebElement servicesMenuOption;
    @FindBy(xpath = "//span[text()='Save and Continue']")
    WebElement amendContinue;
    @FindBy(xpath = "//h2[text()='Filings']")
    WebElement filingsHeading;
    @FindBy(xpath = "//span[text()='BNA - New Registration of an Extra-Provincial Limited Liability Company Name']")
    WebElement extraPLCN;
    @FindBy(xpath = "//div[@class='appPageTitleInner']//span")
    WebElement ontarioBusinessCorporationHeading;



    @FindBy(xpath = "//span[text()='Cancellation of a Business Name Registration for a Partnership']")
    WebElement cancellationFiling;
    @FindBy(xpath = "//span[contains(text(),'Business Name Registration for a Sole Proprietorsh')]")
//    @FindBy(xpath = "//a[@class='appFilingOpen']//span")
    WebElement amendmentSOBusinessName;
    @FindBy(xpath = "//span[text()='Renewal of a Firm Name Registration for a General Partnership']")
    WebElement renewPartnershipBusinessName;
    @FindBy(xpath = "//span[text()='Renewal of an Ontario Limited Partnership Declaration']")
    WebElement renewalofAnOntarioLimitedPartnershipDeclaration;
    @FindBy(xpath = "//span[text()='Renewal of a Firm Name Registration for a General Partnership']")
    WebElement renewalofRenewARegistration_OfAFirmNameForAGeneralPartnership;


    @FindBy(xpath = "//span[text()='Renewal of a Firm Name Registration for an Ontario Limited Liability Partnership']")
    WebElement renewOntarioLimitedLiabilityPartnershipBusinessName;

    @FindBy(xpath = "//span[contains(text(),'Amendment of an Extra-Provincial Limited Liability')]")
    WebElement amendmentExtraProvincialFiling;
    @FindBy(xpath = "//span[text()='Renewal of an Extra-Provincial Limited Liability Company Name']")
    WebElement renewalExtraProvincialFiling;

    @FindBy(xpath = "//span[contains(text(),'Business Name Registration for a Sole Proprietorship')]")
    WebElement businessNameRegistrationForSolePropFiling;
    @FindBy(xpath = "(//a[@class='appFilingOpen']//span)[2]")
    WebElement newRegistrationFiling;
    @FindBy(xpath = "(//a[@class='appFilingOpen']//span)[1]")
    WebElement fileADeclarationFiling;
    @FindBy(xpath = "//span[text()='Cancellation of a Business Name Registration for a Partnership']")
    WebElement cancelFiling;
    @FindBy(xpath = "//label[contains(@for,'-SameAsPrimaryYnY')]")
    WebElement sameAsCorporationAddress;
    @FindBy(xpath = "//button[contains(@class,'appButton appWizardButton')]")
    WebElement saveAndContinueGP;
    @FindBy(xpath = "//label[contains(@for,'-AuthorizationTypesoleprop')]")
    WebElement soleProprietorOption;
    @FindBy(xpath = "//label[contains(@for,'_RoleIndividuals')]")
    WebElement typeAsIndividualOption;
    @FindBy(xpath = "//h2[text()='Authorization']")
    WebElement authorizationHeading;
    @FindBy(xpath = "//option[contains(@value, 'Contact first CONTACT LAST')]")
    WebElement selectFomPartnersAsContact;
    @FindBy(xpath = "//label[contains(@for,'-AuthorizationType')]")
    WebElement personAuthorizingOption;
    @FindBy(xpath = "//label[text()='Person Acting under Power of Attorney']")
    WebElement personPersonActingUnderPowerOfAttorney;
    @FindBy(xpath = "//span[text()='This Cancellation Confirmation must be accepted before continuing.']")
    WebElement messageCancellationConfirmationMustBeAccepted;
    //    //span[text()='This Cancellation Confirmation must be accepted before continuing.']
    // //label[text()='Person Acting under Power of Attorney']
    @FindBy(xpath = "//select[contains(@id,'-AuthorisingPartner')]")
    WebElement selectFromPartnersOption;
    @FindBy(xpath = "//li[contains(@id,'-CONTACT FIRST CONTACT LAST')]")
    WebElement selectFirstPartner;
    @FindBy(xpath = "//li[contains(@id,'Contact First CONTACT LAST (Director)']")
    WebElement selectFirstDirector;
    @FindBy(xpath = "//label[contains(@id,'-ActiveAuthorizationList')]")
    WebElement selectFromDirectorOption;

    @FindBy(xpath = "//span[contains(@id,'-ActiveAuthorizationList-container')]")
    WebElement selectFromPartnersDropdownContainer;
    @FindBy(xpath = "//label[contains(@for,'-AuthorizationTypepartner')]")
    WebElement partnerOption;
    @FindBy(xpath = "//label[@class='appAttrLabel']")
    WebElement authorizationCheckBox;
    @FindBy(xpath = "//label[contains(@for,'-ConfirmMaintenanceActionYn')]")
    WebElement confirmMaintenanceCheckBox;
    @FindBy(xpath = "//label[contains(@for,'-DeclarationYn')]")
    WebElement decelerationCheckBox;
    @FindBy(xpath = "//div[contains(text(),'Review')]")
    WebElement reviewHeading;
    @FindBy(xpath = "//button[contains(@class,'-wizardButtonPad-apply')]")
    WebElement submitButton;
    @FindBy(xpath = "//button[contains(@class,'amendBusiness')]")
    WebElement submitButtonAmend;
    @FindBy(xpath = "//button[contains(@class,'appButton cancelBusinessNameCorporation-cancelBusinessNameCommon-buttonPad-apply')]")
    WebElement cancelBusinessNameSubmitButton;
    @FindBy(xpath = "(//button[contains(@class,'appButton cancelBusinessNamePartnership-cancelBusinessNameCommon-buttonPad-apply')]//span)[2]")
    WebElement cancelBusinessSubmitButton;
    @FindBy(xpath = "//span[text()='Submit']")
    WebElement selectSubmitButton;

    @FindBy(xpath = "(//div[@class='appAttrValue'])[2]")
    WebElement corporationName;
    @FindBy(xpath = "(//div[@class='appAttrValue'])[3]")
    WebElement ontarioCorporationOCNNumber;


    @FindBy(xpath = "//button[contains(@class,'amendBusinessName')]")
    WebElement amendBusinessSubmitButton;
    @FindBy(xpath = "//span[text()='Search']")
    //@FindBy(id = "QueryString")
    WebElement searchField;
    @FindBy(xpath = "//h2[text()='Owner']")
    WebElement ownerTitle;
    @FindBy(xpath = "//span[text()=' Advanced']")
    WebElement Advanced;
    @FindBy(xpath = "//label[text()='Exact Match']")
    WebElement exactMatch;


    @FindBy(xpath = "(//button[contains(@class,'appButton registerItemSearch-tabs-criteriaAndButtons-buttonPad-search')]//span)[2]")
    WebElement searchButton;
    @FindBy(xpath = "//div[contains(@class,'appRepeaterRowContent appRowOdd')]")
    WebElement searchResults;
    @FindBy(xpath = "//ul[contains(@id,'-CountryCode-results')]")
    WebElement searchResultsGoverningJurisdiction;
    @FindBy(xpath = "//ul[contains(@id,'-RegionCode-results')]")
    WebElement searchResultsProvince;
    @FindBy(xpath = "//span[text()='Status']/following-sibling::span")
    WebElement searchStatus;
    @FindBy(xpath = "//div[text()='Transaction Number']/following-sibling::div")
    WebElement transactionNumberValue;
    @FindBy(xpath = "//h2[text()='Power of Attorney']")
    WebElement powerOfAttorneyHeading;
    @FindBy(xpath = "//span[text()='Business Type']/following-sibling::span")
    WebElement searchBusinessType;
    @FindBy(xpath = "(//a[contains(@class,'registerItemSearch-results-page-line-ItemBox-resultLeft-viewMenu appMenu')]//span)[2]")
    WebElement businessNameValue;
    @FindBy(xpath = "//label[contains(@for,'-ConfirmMaintenanceActionYn')]")
    WebElement cancellationConfirmationCheckBox;
    @FindBy(xpath = "//button[contains(@class,'cancel')]")
    WebElement cancelBusinessRegSubmitButton;
    @FindBy(xpath = "(//button[@type='button']//span)[2]")
    WebElement renewBusinessRegSubmitButton;

    @FindBy(xpath = "//div[@class='appFieldHelp']/following-sibling::input[1]")
    WebElement numberOfPartnersField;
    @FindBy(xpath = "//h2[text()='Partners']")
    WebElement partnersHeading;
    @FindBy(xpath = "(//button[@role='button'])[2]")
    WebElement addPartnerButton;
    @FindBy(xpath = "//span[text()='Add a Partner']/following-sibling::span")
    WebElement addPartnerDropdown;
    @FindBy(xpath = "//button[@data-toggle='dropdown']//span[1]")
    WebElement addPartnerDropdownOption;


    @FindBy(xpath = "(//a[@class='delete negativeLink']//span)[2]")
    WebElement removeLink;
    @FindBy(xpath = "(//li[@role='menuitem']//a)[2]")
    WebElement partnerAsIndividualOption;
    @FindBy(xpath = "//h1[@class='appPageTitle']//span[1]")
    WebElement pageTitle;
    @FindBy(xpath = "(//div[@class='appRepeaterDirect']//h4)[2]")
    WebElement partnerTwoLabel;
    //    @FindBy(xpath = "//button[contains(@class,'appButton registerExtraProvincialLLCName-wizardBox-companyNamesTab-details-currentNameForRegistration-currentEntityNames-currentEntityName-notNumberNameBox-currentNameWithResBox-notResNameOnlyBox-dontUseReservedNameBox-validateNameButton')]")
    @FindBy(xpath = "//button[contains(@class,'-validateNameButton')]")
    WebElement checkNameButton;
    @FindBy(xpath = "//input[@placeholder='Find the address using a postal code...']")
    WebElement findAddressTextArea;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    WebElement partnerTextArea;
    @FindBy(xpath = "//span[@role='textbox']")
    WebElement selectFromPartnersDropdown;
    @FindBy(xpath = "//span[@role='textbox']//span[1]")
    WebElement DirectorsOrOfficers;
    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement DirectorsOrOfficersTextArea;
    @FindBy(xpath = " //b[@role='presentation']")
    WebElement SelectDirectorsOrOfficers;

    // USA Address
    @FindBy(xpath = "//label[text()='US Address']")
    WebElement SelectUSAddress;
    @FindBy(xpath = "//span[text()='-- Select your State --']")
    WebElement SelectUSAState;
    @FindBy(xpath = "//span[text()='Zip Code']/following::input")
    WebElement SelectUSAZipCode;


    @FindBy(xpath = "//span[text()='Change Principal Place of Business']")
    WebElement updatePrincipalPlaceOfBusinessPlus;
    @FindBy(xpath = "//input[@type='radio']/following-sibling::label")
    WebElement updatePrincipalPlaceOfBusinessPlusYes;
    @FindBy(xpath = "//div[@class='appRestricted appRestrictedSelect']//select[1]")
    WebElement selectFromPartners;
    @FindBy(xpath = "//a[@title='Opens a popup dialog']")
    WebElement findAddressButton;

    @FindBy(xpath = "//input[@name='pcLookupSelection']")
    WebElement pcLookupSelection;
    @FindBy(xpath = "//a[@id='pcLookupOkButton']")
    WebElement pcLookupOkButton;

    @FindBy(xpath = "//div[@class='appAttrLabelBox']/following-sibling::div[1]")
    WebElement textAddressOf;
    @FindBy(xpath = "//span[text()='Edit']")
    WebElement editAddress;
    @FindBy(xpath = "//span[text()='Street Number']/following::input")
    WebElement streetNumberAddress;
    @FindBy(xpath = "//label[contains(@for,'-SameAsPrimaryYnY')]")
    WebElement addressSameAsCorporation;

    @FindBy(xpath =  "//input[@placeholder='123']")
    WebElement streetNumberRegister;

    @FindBy(xpath = "(//input[@type='radio']/following-sibling::label)[2]")
    WebElement internationalAddressOption;
    @FindBy(xpath = "//label[text()='Different Address']")
    WebElement differentAddress;
    @FindBy(xpath = "//label[text()='International Address']")
    WebElement internationalAddress;
    @FindBy(xpath = "//span[text()='Address line 1']/following::input")
    WebElement internationalAddressLine1;
    @FindBy(xpath = "//span[text()='City/Town']/following::input")
    WebElement internationalCityTown;
    @FindBy(xpath = "//input[contains(@id,'-PostCode')]") // "//span[text()='Postal Code']/following::input")
    WebElement internationalPostalCode;
    @FindBy(className = "select2-selection__rendered")
    WebElement internationalCountry;
    @FindBy(className = "//input[@role='searchbox']")
    WebElement internationalCountrySearchbox;


    @FindBy(xpath = "//span[contains(text(),'Edit')]")
    WebElement editButton;
    @FindBy(xpath = "//a[contains(@class,'delete negativeLink')]")
    WebElement removeButton;
    @FindBy(xpath = "//button[contains(@class,'appButton appButtonSecondary')]")
    WebElement doneButton;
    @FindBy(css = "input[id*='-FirstName']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[contains(@id,'-FirstName')]")
    WebElement firstNameFieldValue;
    @FindBy(xpath = "//input[contains(@id,'-LastName')]")
//    @FindBy(css = "input[id*='-LastName']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[contains(@id,'-LastName')]")
    WebElement lastNameFieldValue;

    @FindBy(xpath = "//span[text()='First Name']/following::input")
    WebElement firstName;
    @FindBy(xpath = "//span[text()='Last Name']/following::input")
    WebElement lastName;

    @FindBy(xpath = "//label[contains(@for, '-UseNumberNameYnN')]")
    WebElement willThisCorporationHaveNumberNameNoButton;
    @FindBy(xpath = "//label[contains(@for,'-NameTypeen')]")
    WebElement corporationWillHaveEnglishOption;
    @FindBy(xpath = "//div[@class='appAttrLabelBox']/following-sibling::input[1]")
    WebElement nuansReportValue;
    //    @FindBy(xpath = "//input[contains(@id,'-Name')]")
//    @FindBy(xpath = "//span[text()='Proposed Business Name']/following::input")
    @FindBy(xpath = "//div[@class='appFieldHelp']/following-sibling::input[1]")
    WebElement corporationNameValue;
    @FindBy(css = "div#folder0>div:nth-of-type(2)>div:nth-of-type(4)>span:nth-of-type(2)")
    WebElement getNuansReportNumber;
    @FindBy(css = "div#folder1>div>span:nth-of-type(2)>span>span:nth-of-type(2)")
    WebElement nuansReportNumber;
    @FindBy(css = "nuans_report_list:nth-child(1) > nuans_report_item:nth-child(4)")
    WebElement nuansReportNumberFirefox;
    @FindBy(css = "div#folder1 > div:nth-of-type(2) > div:nth-of-type(1) > span:nth-of-type(2)")
    WebElement nuansReportTitle;
    @FindBy(xpath = "/nuans_report_list/nuans_report_item[1]/report_title")
    WebElement nuansReportTitleFirefox;
    @FindBy(css = "select[id*='-LegalExtensionCode']")
    WebElement legalElementForNumberName;
    //    @FindBy(xpath = "//*[@id=\"nodeW1435\"]/button/span[2]/span")
    @FindBy(xpath = "//label[contains(@for,'-AddressSubTypeUS')]")
    WebElement usAddressOption;
    @FindBy(xpath = "//button[contains(@class,'brRegisterLocalCompany-asyncContainer-wizardBox-detailsTab-details-localNameBox-currentEntityNames-currentEntityName-notNumberNameBox-enName-resetNuansReport')]")
    WebElement clearNameButton;
    @FindBy(xpath = "//button[contains(@class,'appButton registerExtraProvincialLicenceForForeignCorporationWithShare-asyncContainer-wizardBox-detailsTab-details-localNameBox-currentEntityNames-currentEntityName-notNumberNameBox-enName-resetNuansReport appButtonSecondary appPullRight appNotReadOnly appIndex3')]")
    WebElement clearNameButtonForeign;
    @FindBy(xpath = "//input[contains(@id, '-RegistrationDate')]")
    WebElement requestDateForIncorporationDateValue;
    @FindBy(xpath = "//input[@class='webuiValidateDate hasDatepicker']/following-sibling::button[1]")
    WebElement requestDateForIncorporationDateSelectionIconNotForProfit;
    @FindBy(xpath = "//input[contains(@class,'appInlineButtons appAttrDate')]/following-sibling::button[1]")
    WebElement requestDateForIncorporationDateSelectionIconExtraProvincial;
    @FindBy(xpath = "//input[@class='webuiValidateDate hasDatepicker']/following-sibling::button[1]")
    WebElement requestDateForIncorporationDateSelectionIcon;
    //    @FindBy(xpath = "//input[contains(@class,'appInlineButtons appAttrDate')]/following-sibling::button[1]")
    @FindBy(xpath = "//button[contains(@class,'ui-datepicker-trigger')]")
    WebElement nuansReportDateSelectionIcon;
    @FindBy(xpath = "//input[@class='webuiValidateDate hasDatepicker']/following-sibling::button[1]")
    WebElement jurisdictionDateSelectionIcon;
    @FindBy(xpath = "//input[contains(@class,'appAttrLabelFullWidth appAttrDate')]/following-sibling::button[1]")
    WebElement foreignDateSelectionIcon;
    @FindBy(xpath = "//span[contains(@id,'-RegionCode-container')]")
    WebElement stateOption;
    @FindBy(xpath = "//option[contains(text(),'Arizona')]")
    WebElement stateOptionArizona;
    @FindBy(xpath = "//input[@class='webuiValidateDate hasDatepicker']/following-sibling::button[1]")
    WebElement requiredStatementDateIcon;
    @FindBy(xpath = "//a[contains(@class,'ui-state-default ui-state-highlight')]")
    WebElement jurisdictionTodaysDate;
    @FindBy(xpath = "//a[contains(@class,'ui-state-default ui-state-highlight')]")
    WebElement requestDateForIncorporationTodaysDate;
    @FindBy(xpath = "(//button[contains(@class, 'appDocumentUploadLink')])[2]")
    WebElement uploadFileOverlap;
    @FindBy(xpath = "//label[contains(text(),'Individual')]")
    WebElement individualTypeOption;
    @FindAll(@FindBy(xpath = "//*[contains(@class,'appDocumentUploadLink appButton')]"))
    List<WebElement> uploadButton;
    @FindBy(xpath = "//input[@type='file']")
    WebElement uploadButtonInput;
    @FindBy(xpath = "(//input[@type='file'])[2]")
    WebElement uploadButtonContactInfo;
    @FindAll(@FindBy(xpath = "//input[@type='file']"))
    List<WebElement> uploadButtonList;
    @FindBy(xpath = "//div[contains(@id,'_upload_button')]")
    WebElement JurisdictionUploadButton;
    @FindBy(xpath = "//div[@id='vs1__combobox']")
    WebElement primaryActivityTypeContainer;
    //h1[@class='appPageTitle']//span[1]
    @FindBy(css = "h1#content>span")
    WebElement articlesOfContinuanceBusinessCorporationActTitle;
    //    @FindBy(xpath = "//span[text()='Truck transportation']")
    @FindBy(xpath = "//h2[contains(text(),'Purposes & Provisions')]")
    WebElement purposesAndProvisionsHeading;
    @FindBy(xpath = "//label[contains(@for,'-CharityYnY')]")
    WebElement operateAsCharityYesOption;
    @FindBy(xpath = "//textarea[contains(@id,'-Purposes')]")
    WebElement purposeOfCorporationTextArea;
    @FindBy(xpath = "//textarea[contains(@id,'-SpecialProvisions')]")
    WebElement additionalSpecialProvisionsTextArea;
    @FindBy(xpath = "//button[contains(@class,'appButton appWizardButton')]")
    WebElement saveAndContinueButton;
    @FindBy(xpath = "(//button[@role='button'])[3]")
    WebElement uploadButtonFirst;
    @FindBy(xpath = "//div[@class='appRestricted appRestrictedSelect']//select")
    WebElement entityStatus;
    @FindBy(xpath = "(//div[@class='appRestricted appRestrictedSelect']//select)[2]")
    WebElement entitySubStatus;
    @FindBy(xpath = "//span[text()='Comments']/following::textarea")
    WebElement entitySubStatusComments;
    @FindBy(xpath = "//span[text()='Add a Liquidator'] ")
    WebElement addALiquidator;
    @FindBy(xpath = "//span[text()='Individual']")
    WebElement individualLink;


    @FindBy(xpath = "//div[contains(@id,'_upload_button')]")
    WebElement uploadButtonNonList;
    @FindBy(xpath = "//h2[contains(text(),'Appointment of Agent for Service in Ontario')]")
    WebElement appointmentOfAgentHeader;
    @FindBy(xpath = "//h2[contains(text(),'Chief Officer or Manager')]")
    WebElement chiefOfficerHeader;
    @FindBy(xpath = "//label[contains(text(),'Yes')]")
    WebElement corporationAppointedOptionYes;
    @FindBy(xpath = "//h2[contains(text(),'Address')]")
    WebElement addressHeading;
    @FindBy(xpath = "//span[contains(text(), 'Enter address manually')]")
    WebElement enterAddressManuallyLink;
    @FindBy(xpath = "//label[contains(text(),'US Address')]")
    WebElement USAddressOption;
    @FindBy(xpath = "//div[contains(@class,'appAttrText incorporateNotForProfitCorp-asyncContainer-wizardBox-directorsTab-repeaterCategorizerBox-categorizerBox-repeaterNotPaged-directorRepeater-director-dirBox-fullLegalName-individualName-FirstName')]//input[1]/following::span[text()='Enter address manually']")
    WebElement enterAddressManuallyLinkNotForProfit;
    @FindBy(xpath = "//input[contains(@id,'-Address1')]")
    WebElement streetNumberValue;
    @FindBy(xpath = "//input[contains(@id, '-Address2')]")
    WebElement streetNameValue;
    @FindBy(xpath = "//input[contains(@id,'-Address4')]")
    WebElement cityValue;
    @FindBy(xpath = "//input[contains(@id,'-PostCode')]")
    WebElement postalCodeValue;
    @FindBy(xpath = "//label[contains(text(),'Fixed Number')]")
    WebElement fixedNumberOption;
    @FindBy(xpath = "//input[contains(@id,'-NumberOfDirectorsValue1')]")
    WebElement fixedNumberOfDirectorsValue;
    @FindBy(xpath = "//button[contains(@class,'appButton appRepeaterAdd')]")
    WebElement addADirectorButton;
    @FindBy(xpath = "//span[contains(text(),'Add Me as Director')]")
    WebElement addMeAsDirectorButton;
    @FindBy(xpath = "//label[contains(@for,'-ResidentYnY')]")
    WebElement residentCanadaYesOption;
    @FindBy(xpath = "//input[contains(@id,'-addressLookup')]")
    WebElement addressLookupField;
    @FindBy(xpath = "//span[contains(text(), 'Enter address manually')]")
    WebElement enterAddressManually;


    @FindBy(xpath = "//div[contains(@id, 'Title')]")
    WebElement directorTitle;
    @FindBy(xpath = "//label[contains(@for,'-IsAnIncorporatorYnY')]")
    WebElement alsoAnIncorporatorYesOption;
    @FindBy(xpath = "//button[contains(@class,'appButton appButtonSecondary')]")
    WebElement doneButtonNotForProfit;
    @FindBy(xpath = "//label[text()='Use pre-defined text (suggested for private companies)']")
    WebElement sharesAndProvisionsPreDefinedTextOption;
    //    @FindBy(xpath = "//h3[contains(text(),'Other Provisions, if any')]")
//    WebElement sharesAndProvisionsOtherProvisionsHeading;
    @FindBy(xpath = "//h2[contains(text(),'Shares & Provisions')]")
    WebElement sharesAndProvisionsHeading;
    @FindBy(xpath = "//textarea[contains(@id,'-ShareClassDesc')]")
    WebElement descriptionOfClassesTextArea;
    @FindBy(xpath = "//textarea[contains(@id,'-ShareRights')]")
    WebElement rightsPrivilegesTextArea;
    @FindBy(xpath = "//textarea[contains(@id,'-ShareTransferDesc')]")
    WebElement restrictionsOnShareTextArea;
    @FindBy(xpath = "//textarea[contains(@id,'-ShareBusinessDesc')]")
    WebElement restrictionsOnBusinessTextArea;
    @FindBy(xpath = "//textarea[contains(@id,'-OtherProvisionDesc')]")
    WebElement otherProvisionsTextArea;
    @FindBy(xpath = "//h2[text()='General Details']")
    WebElement generalDetailsHeading;
    @FindBy(xpath = "//div[contains(text(),'Inactive - Cancellation of BNLP')]")
    WebElement inactiveStatusValue;
    @FindBy(xpath = "//div[contains(text(),'Inactive - Termination of EPL')]")
    WebElement inactiveTerminationStatusValue;

    @FindBy(xpath = "//h2[contains(text(),'Required Statements')]")
    WebElement requiredStatementsHeading;
    @FindBy(xpath = "//input[@type='checkbox']/following-sibling::label")
    WebElement continueUnderBusinessCorporationActCheckBox;
    @FindBy(xpath = "(//div[@class='appRestricted appRestrictedYesNo']//label)[2]")
    WebElement compliedWithSubSectionCheckBox;
    @FindBy(xpath = "//label[text()='The continuation of the corporation under the laws of the Province of Ontario has been properly authorized under the laws of the jurisdiction currently governing the corporation, on the following date:']")
    WebElement authorizationDateCheckBox;
    @FindBy(xpath = "//div[@id='pageTitle']")
    WebElement incorporateOntarioBusinessCorporationBanner;
    @FindBy(xpath = "//h2[contains(text(),'Incorporator')]")
    WebElement incorporatorsHeading;
    @FindBy(xpath = "//h2[text()='Corporation Name']")
    WebElement corporationNameHeading;
    @FindBy(xpath = "//h1[@class='appPageTitle']//span[1]")
    WebElement notForProfitCorporationHeading;
    @FindBy(xpath = "//label[@class='appAttrLabel']")
    WebElement printedAndSavedConfirmationCheckBox;
    @FindBy(xpath = "//div[text()[normalize-space()='Generate PDF']]")
    WebElement generatePDFButton;
    @FindBy(xpath = "//span[contains(text(),'Jurisdiction')]")
    WebElement jurisdictionProgressLink;
    @FindBy(xpath = "//div[text()='Review & Authorization']")
    WebElement reviewAndAuthorizationHeading;
    @FindBy(xpath = "//button[contains(@class, 'continueInAsONBusinessCorp')]")
    WebElement continueButton;
    @FindBy(xpath = "//h1[text()='Contact Information']/following::button")
    WebElement contactInformationContinueButton;
    @FindBy(xpath = "//h1[text()='Contact Information']/following::button")
    WebElement continueButtonIncorporateOntarioBusinessCorporation;
    @FindBy(xpath = "//button[@type='button']")
    WebElement feePaymentContinueButton;
    @FindBy(xpath = "//span[text()='Continue']")
    WebElement paymentConfirmationContinueButton;
    @FindBy(xpath = "//h2[contains(text(),'Sent For Review')]")
    WebElement sentForReviewTitle;
    @FindBy(xpath = "//a[@id='sentForReviewDialogOkButton']")
    WebElement okButton;
    @FindBy(xpath = "//h2[text()='Jurisdiction']")
    WebElement jurisdictionHeading;
    @FindBy(xpath = "//label[contains(text(),'No')]")
    WebElement corporationPreviouslyRegisteredInOntarioNoOption;
    @FindBy(xpath = "//span[contains(@id,'-CountryCode-container')]")
    WebElement governmentJurisdictionOption;
    @FindBy(xpath = "//option[contains(text(),'United States')]")
    WebElement governmentJurisdictionOptionUS;
    @FindBy(xpath = "//span[contains(text(),'Review & Authorization')]")
    WebElement reviewAndAuthorizationProgressLink;
    @FindBy(xpath = "//select[contains(@id,'-Method')]")
    WebElement paymentMethodOption;
    @FindBy(xpath = "//label[contains(@id, '-PreviousName_label')]")
    WebElement currentCorporationNameLabel;
    @FindBy(xpath = "//input[contains(@id, '-PreviousName')]")
    WebElement currentCorporationNameValue;
    @FindBy(xpath = "//option[contains(text(),'Canada')]")
    WebElement jurisdictionLocationCanada;
    @FindBy(xpath = "//span[contains(@id,'-CountryCode-container')]")
    WebElement jurisdictionDropdown;
    @FindBy(xpath = "//span[contains(text(),'-- Please Select --')]")
    WebElement provinceDropdown;
    @FindBy(xpath = "//span[contains(text(),'-- Select your Province --')]")
    WebElement provinceDropdownAddDirector;
    //span[text()='Sa']/following::input
    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement jurisdictionSearchArea;
    @FindBy(xpath = "//li[contains(@id,'-CountryCode-result-cl6n-US')]")
    WebElement jurisdictionSearchResultUS;
    @FindBy(xpath = "//span[@class='select2-results']")
    WebElement jurisdictionSearchResultCanada;
    @FindBy(xpath = "//input[@class='webuiValidateDate hasDatepicker']")
    WebElement jurisdictionDateField;
    @FindBy(xpath = "//*[@id=\"visa\"]")
    WebElement paymentMethodVisa;
    @FindBy(xpath = "//input[@id='Interact_Online']")
    WebElement paymentMethodInteract;
    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitMakeAPaymentButton;
    @FindBy(xpath = "//li[@id='bank1']//input[@id='btnBank']")
    WebElement bankOneButton;
    @FindBy(xpath = "//form[@id='frmBankLogin']/input[11]")
    WebElement loginButton;
    @FindBy(xpath = "//p[text()='Card Number']")
    WebElement cardNumberLabel;
    @FindBy(css = "div#content>h1>span")
    WebElement testBankHeading;
    @FindBy(xpath = "//form[@id='frmBankLogin']/input[16]")
    WebElement sendNowButton;
    @FindBy(css = "select#accountType")
    WebElement fromAccountOption;
    @FindBy(css = "input[id*='ExpiryDate']")
    WebElement expiryDate;
    @FindBy(xpath = "//input[@class='webuiValidateDate hasDatepicker']")
    WebElement reregistrationDate;
    ;
    @FindBy(xpath = "//form[@id='frmBankLogin']/input[16]")
    WebElement nextButton;
    @FindBy(xpath = "//span[contains(text(),'Clicking on NEXT > will log you out of online bank')]")
    WebElement clickingOnNextText;
    @FindBy(xpath = "//span[text()='Payment Confirmation']")
    WebElement paymentConfirmationButton;
    @FindBy(xpath = "//div[@class='appRestricted appRestrictedYesNo']//label")
    WebElement CancellationConfirmation;
    @FindBy(xpath = "//span[text()='Authorization']")
    WebElement amendAuthorization;
    @FindBy(xpath = "//div[@class='appRestricted appRestrictedSelect']//select[1]")
    WebElement amendSelectFromPartners;
    @FindBy(xpath = "//input[@type='checkbox']/following-sibling::label[1]")
    WebElement amendConfirm;
    @FindBy(xpath = "(//button[@type='button']//span)[2]")
    WebElement amendSubmit;
    @FindBy(xpath = "//span[text()='Partners']")
    WebElement amendPartnersTab;
    @FindBy(xpath = "//span[text()='Edit']")
    WebElement amendPartner1Edit;
    @FindBy(xpath = "//span[text()='Street Number']/following::input")
    WebElement amendPartnersStreetNumber;
    @FindBy(xpath = "//span[text()='Done']")
    WebElement amendPartnersDone;
    @FindBy(xpath = "//span[text()='Correct the Register']")
    WebElement correctTheRegister;
    @FindBy(xpath = "//span[text()='Correct Version']")
    WebElement correctVersion;
    //    @FindBy(xpath = "//DIV[@role=\"dialog\"][1]/DIV[@role=\"alert\"][1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/FIELDSET[1]/DIV[1]/DIV[1]/LABEL[1]")
//    @FindBy(xpath = "//label[text()='Director/Registrar']")
    @FindBy(xpath = "//label[contains(text(),'Registrar')]")
    WebElement Registrar;
    //   @FindBy(xpath = "//DIV[@role=\"dialog\"][1]/DIV[@role=\"alert\"][1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[3]/DIV[1]/DIV[1]/TEXTAREA[1]")
    @FindBy(xpath = "//span[text()='Description of Correction']/following::textarea")

    WebElement changeExpiryDates;
    @FindBy(css = "input[id*='RemovalReasonCode']")
    WebElement removalReasonCode;

    @FindBy(css ="//*[@id=\"flashContent\"]")
    WebElement emailConfirmationMessage;
    @FindBy(css = "//*[@id=\"flashOkButton\"]")
    WebElement flashOkButton;

    @FindBy(xpath = "//*[(text() = 'Services' or . = 'Services')]")
    WebElement servicesTab;
    @FindBy(xpath = "//span[text() = 'Register Services']")
    WebElement registerServicesMenuOption;
    @FindBy(xpath = "//a[@class = 'appSubMenuName menu-companies' and @href = '#']")
    WebElement corporationsSubMenuOption;
    @FindBy(xpath = "//span[text()='Sole Proprietorship']")
    WebElement SoleProprietorshipSubMenuOption;
    @FindBy(xpath = "//span[text()='Register a Business Name for a Sole Proprietorship']")
    WebElement registerBusinessNameSoleProprietorshiSubMenuOption;
    @FindBy(xpath = "//span[text() = 'Incorporate an Ontario Business Corporation']")
    WebElement incorporateOntarioBusinessCorporationSubMenuOption;
//    @FindBy(xpath = "//div[contains(@class,'brViewLocalCompany-companyMenusBox-item')]")
    @FindBy(xpath = "//span[text()='Make Changes']") //
    WebElement makeChangesMenuOption;
    @FindBy(xpath = "//span[text()='File Articles of Arrangement']")
    WebElement fileArticlesOfArrangementIncorporationOption;
    @FindBy(xpath = "//span[text()='File Articles of Revival']")
    WebElement fileArticlesOfRevivalOption;
    @FindBy(xpath = "//*[contains(text(),'of Revival')]")
    WebElement articlesOfRevivalOption;



    @FindBy(xpath = "//label[text()='No']")
    WebElement reviewNo;
    @FindBy(xpath = "//span[text()='Ok']")
    WebElement warnningOk ;
    @FindBy(xpath = "//div[@class='appFieldHelp']/following-sibling::textarea[1]")
    WebElement summaryOfChanges ;
    @FindBy(xpath = "//input[@class='webuiValidateDate hasDatepicker']")
    WebElement requestedDateForArrangement ;
    @FindBy(xpath = "/html/body/div[1]/div/div[6]/div/div/div[1]/div/form/div[2]/div/div[1]/div/div[3]/div[6]/div/div[1]/div/div/div/div/div/div/div/div/div/div[4]/div/button")
    WebElement planOfArrangementUpload ;
    @FindBy(xpath = "/html/body/div[1]/div/div[6]/div/div/div[1]/div/form/div[2]/div/div[1]/div/div[3]/div[6]/div/div[1]/div/div/div/div/div/div/div/div/div/div[5]/div/button")
    WebElement courtOrderUpload ;
    @FindBy(xpath = "//input[@type='checkbox']/following-sibling::label[1]")
    WebElement authorizationCheckbox ;








    public String businessNameSoleProprietorship;
    public String searchForABusinessName = "FN6LOFFPWA";

    public String completeBusinessNameRegistrationAndSaveLLP() throws InterruptedException {
        String randomBusinessName = HelperMethods.randomString() + " LLP";
        logger.warn("Business name is: " + randomBusinessName);
        HelperMethods.fluentWaitAndCheckVisible(proposedBusinessNameField, driver);
        HelperMethods.waitAndSendKeys(proposedBusinessNameField, randomBusinessName, driver);
        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);

        if (pageTitle.getText().contains(Config.REGISTER_EXTRA_PROVINCIAL_LIMITED_LIABILITY_TITLE)) {
            HelperMethods.fluentWaitAndClick(governingJurisdictionOptionList, driver);
            HelperMethods.fluentWaitAndCheckVisible(governingJurisdictionSearchArea, driver);
            HelperMethods.waitAndSendKeys(governingJurisdictionSearchArea, Config.CANADA_LABEL, driver);
            HelperMethods.fluentWaitAndClick(searchResultsGoverningJurisdiction, driver);

            HelperMethods.fluentWaitAndCheckVisible(provinceOptionList, driver);
            HelperMethods.fluentWaitAndClick(provinceOptionList, driver);
            HelperMethods.fluentWaitAndCheckVisible(governingJurisdictionSearchArea, driver);
            HelperMethods.waitAndSendKeys(governingJurisdictionSearchArea, Config.FEDERAL_LABEL, driver);
            HelperMethods.fluentWaitAndCheckVisible(searchResultsProvince, driver);
            HelperMethods.fluentWaitAndClick(searchResultsProvince, driver);
            HelperMethods.staleElementVisible(pageTitle, driver);
            HelperMethods.staleElementVisible(checkNameButton, driver);
        } else {
            HelperMethods.fluentWaitAndClick(primaryActivityType, driver);
            HelperMethods.fluentWaitAndCheckVisible(primaryActivityType, driver);
            HelperMethods.waitAndSendKeys(primaryActivityType, Config.AMBULATORY_HEALTH_CARE_SERVICE_LABEL, driver);
            Thread.sleep(1800);


            HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeAmbulatoryHealthCareServices, driver);
            HelperMethods.waitAndClick(primaryActivityTypeAmbulatoryHealthCareServices, driver);

//            HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
//            HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);
            HelperMethods.staleElementVisible(saveAndContinue, driver);
            HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        }
        return randomBusinessName;
    }

    public String completeBusinessNameRegistrationAndSaveExtraProvincial() throws InterruptedException {
        String randomBusinessName = HelperMethods.randomString() + " LLP";

        if (pageTitle.getText().contains(Config.REGISTER_FIRM_NAME_FOR_EXTRA_PROVINCIAL_LIMITED_LIABILITY_PARTNERSHIP_TITLE)) {

            logger.warn("Business name is: " + randomBusinessName);
            HelperMethods.fluentWaitAndCheckVisible(proposedBusinessNameField, driver);
            HelperMethods.waitAndSendKeys(proposedBusinessNameField, randomBusinessName, driver);
            HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
            HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
            HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);

            HelperMethods.fluentWaitAndClick(governingJurisdictionOptionList, driver);
            HelperMethods.fluentWaitAndCheckVisible(governingJurisdictionSearchArea, driver);
            HelperMethods.waitAndSendKeys(governingJurisdictionSearchArea, Config.CANADA_LABEL, driver);
            HelperMethods.fluentWaitAndClick(searchResultsGoverningJurisdiction, driver);

            HelperMethods.fluentWaitAndCheckVisible(provinceOptionList, driver);
            HelperMethods.fluentWaitAndClick(provinceOptionList, driver);
            HelperMethods.fluentWaitAndCheckVisible(governingJurisdictionSearchArea, driver);
            HelperMethods.waitAndSendKeys(governingJurisdictionSearchArea, Config.FEDERAL_LABEL, driver);
            HelperMethods.fluentWaitAndCheckVisible(searchResultsProvince, driver);
            HelperMethods.fluentWaitAndClick(searchResultsProvince, driver);
            HelperMethods.staleElementVisible(pageTitle, driver);
            HelperMethods.staleElementVisible(checkNameButton, driver);

            Thread.sleep(1200);
            HelperMethods.fluentWaitAndClick(primaryActivityType, driver);
            HelperMethods.fluentWaitAndCheckVisible(primaryActivityType, driver);
            HelperMethods.waitAndSendKeys(primaryActivityType, Config.AMBULATORY_HEALTH_CARE_SERVICE_LABEL, driver);
            Thread.sleep(1200);
            HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeAmbulatoryHealthCareServices, driver);
            HelperMethods.waitAndClick(primaryActivityTypeAmbulatoryHealthCareServices, driver);
//            HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
//            HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);
            HelperMethods.staleElementVisible(saveAndContinue, driver);
            HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        }
        return randomBusinessName;
    }

    public String completeBusinessNameRegistrationGeneralPartnershipAndSave() throws InterruptedException {
        String randomBusinessName = HelperMethods.randomString();
        logger.warn("Business name is: " + randomBusinessName);
        Reporter.log("Business name is: " + randomBusinessName + "\n");
        HelperMethods.fluentWaitAndCheckVisible(proposedBusinessNameField, driver);
        HelperMethods.waitAndSendKeys(proposedBusinessNameField, randomBusinessName, driver);
        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);

        HelperMethods.fluentWaitAndClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "truck transportation", driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        if (pageTitle.getText().contains(Config.REGISTER_EXTRA_PROVINCIAL_LIMITED_LIABILITY_TITLE)) {
            HelperMethods.fluentWaitAndClick(governingJurisdictionOptionList, driver);
            HelperMethods.fluentWaitAndCheckVisible(governingJurisdictionSearchArea, driver);
            HelperMethods.waitAndSendKeys(governingJurisdictionSearchArea, Config.CANADA_LABEL, driver);
            HelperMethods.fluentWaitAndClick(searchResultsGoverningJurisdiction, driver);

            HelperMethods.fluentWaitAndCheckVisible(provinceOptionList, driver);
            HelperMethods.fluentWaitAndClick(provinceOptionList, driver);
            HelperMethods.fluentWaitAndCheckVisible(governingJurisdictionSearchArea, driver);
            HelperMethods.waitAndSendKeys(governingJurisdictionSearchArea, Config.FEDERAL_LABEL, driver);
            HelperMethods.fluentWaitAndCheckVisible(searchResultsProvince, driver);
            HelperMethods.fluentWaitAndClick(searchResultsProvince, driver);
            HelperMethods.staleElementVisible(pageTitle, driver);
            HelperMethods.staleElementVisible(checkNameButton, driver);
        }
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        Thread.sleep(1500);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

        return randomBusinessName;
    }
    public String completeBusinessNameRegistrationAndSave() throws InterruptedException {
        String randomBusinessName = HelperMethods.randomString();
        logger.warn("Business name is: " + randomBusinessName);
        HelperMethods.fluentWaitAndCheckVisible(proposedBusinessNameField, driver);
        HelperMethods.waitAndSendKeys(proposedBusinessNameField, randomBusinessName, driver);
        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);

        HelperMethods.fluentWaitAndClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "truck transportation", driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        if (pageTitle.getText().contains(Config.REGISTER_EXTRA_PROVINCIAL_LIMITED_LIABILITY_TITLE)) {
            HelperMethods.fluentWaitAndClick(governingJurisdictionOptionList, driver);
            HelperMethods.fluentWaitAndCheckVisible(governingJurisdictionSearchArea, driver);
            HelperMethods.waitAndSendKeys(governingJurisdictionSearchArea, Config.CANADA_LABEL, driver);
            HelperMethods.fluentWaitAndClick(searchResultsGoverningJurisdiction, driver);

            HelperMethods.fluentWaitAndCheckVisible(provinceOptionList, driver);
            HelperMethods.fluentWaitAndClick(provinceOptionList, driver);
            HelperMethods.fluentWaitAndCheckVisible(governingJurisdictionSearchArea, driver);
            HelperMethods.waitAndSendKeys(governingJurisdictionSearchArea, Config.FEDERAL_LABEL, driver);
            HelperMethods.fluentWaitAndCheckVisible(searchResultsProvince, driver);
            HelperMethods.fluentWaitAndClick(searchResultsProvince, driver);
            HelperMethods.staleElementVisible(pageTitle, driver);
            HelperMethods.staleElementVisible(checkNameButton, driver);
        }
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        Thread.sleep(1500);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

        return randomBusinessName;
    }
    public String completeExtraProvincialLimitedLiabilityCompanyBusinessNameRegistrationAndSave() throws InterruptedException {
        String randomBusinessName = HelperMethods.randomString();
        logger.warn("Business name is: " + randomBusinessName);
        HelperMethods.fluentWaitAndCheckVisible(proposedBusinessNameField, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(proposedBusinessNameField, randomBusinessName, driver);
        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);

        HelperMethods.fluentWaitAndClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "truck transportation", driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        if (pageTitle.getText().contains(Config.REGISTER_EXTRA_PROVINCIAL_LIMITED_LIABILITY_TITLE)) {
            HelperMethods.fluentWaitAndClick(governingJurisdictionOptionList, driver);
            HelperMethods.fluentWaitAndCheckVisible(governingJurisdictionSearchArea, driver);
            HelperMethods.waitAndSendKeys(governingJurisdictionSearchArea, Config.CANADA_LABEL, driver);
            HelperMethods.fluentWaitAndClick(searchResultsGoverningJurisdiction, driver);

            HelperMethods.fluentWaitAndCheckVisible(provinceOptionList, driver);
            HelperMethods.fluentWaitAndClick(provinceOptionList, driver);
            HelperMethods.fluentWaitAndCheckVisible(governingJurisdictionSearchArea, driver);
            HelperMethods.waitAndSendKeys(governingJurisdictionSearchArea, Config.FEDERAL_LABEL, driver);
            HelperMethods.fluentWaitAndCheckVisible(searchResultsProvince, driver);
            HelperMethods.fluentWaitAndClick(searchResultsProvince, driver);
            HelperMethods.staleElementVisible(pageTitle, driver);
            HelperMethods.staleElementVisible(checkNameButton, driver);
        }
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        Thread.sleep(3500);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

        return randomBusinessName;
    }
    public void incompleteGeneralPartnershipBusinessNameRegistrationNotSave() throws InterruptedException {
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        HelperMethods.fluentWaitAndClick(buttonBusinessName, driver);
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Firm Name must be entered.']")), "Business Name Error", "Firm Name must be entered.");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Firm Name must be entered.']")), "Proposed Business Name", "Firm Name must be entered.");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Primary Activity must be entered.']")), "Primary Activity", "Primary Activity must be entered.");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Official Email must be entered.']")), "Official Email", "Official Email must be entered.");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Confirm Official Email must be entered.']")), "Confirm Official Email", "Confirm Official Email must be entered.");

        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndClick(fileArticlesOfAmalgamationAddress, driver);
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Do you have a place of business in Ontario? must be selected.']")), "Principal Place of Business Error", "Do you have a place of business in Ontario? must be selected.");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Do you have a place of business in Ontario?']")), "Principal Place of Business - Yes/No -Not answered", "Do you have a place of business in Ontario?");
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='Authorization']")), driver);
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='No valid partners currently available to select from.']")), "Last Name", "No valid partners currently available to select from.");
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='Review']")), driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Incomplete']")), "Firm Name", "Incomplete");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("(//span[text()='Incomplete'])[2]")), "Address", "Incomplete");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("(//span[text()='Incomplete'])[3]")), "Partners", "Incomplete");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("(//span[text()='Incomplete'])[4]")), "Authorization", "Incomplete");
        HelperMethods.verifyElementGrey(selectSubmitButton);

//
//        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Last Name must be entered.']")), "Last Name", "Last Name must be entered.");
//        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Street Name must be entered.']")), "Street Name", "Street Name must be entered.");
//        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Street Number must be entered.']")), "Street Number", "Street Number must be entered.");
//        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='City/Town must be entered.']")), "City/Town", "City/Town must be entered.");
//        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Province must be selected']")), "Province", "Province must be selected");
//        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Postal Code must be entered']")), "Postal Code", "Postal Code must be entered");
//        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
//        Thread.sleep(5000);
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
//        HelperMethods.verifyElementGrey(selectSubmitButton);

    }


    public void incompleteBusinessNameRegistrationNotSave() throws InterruptedException {
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        HelperMethods.fluentWaitAndClick(buttonBusinessName, driver);
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Proposed Business Name must be entered.']")), "Business Name Error", "Proposed Business Name must be entered.");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Proposed Business Name must be entered.']")), "Proposed Business Name", "Proposed Business Name must be entered.");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Primary Activity must be entered.']")), "Primary Activity", "Primary Activity must be entered.");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Official Email must be entered.']")), "Official Email", "Official Email must be entered.");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Confirm Official Email must be entered.']")), "Confirm Official Email", "Confirm Official Email must be entered.");

        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndClick(fileArticlesOfAmalgamationAddress, driver);
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Do you have a place of business in Ontario? must be selected.']")), "Principal Place of Business Error", "Do you have a place of business in Ontario? must be selected.");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Do you have a place of business in Ontario?']")), "Principal Place of Business - Yes/No -Not answered", "Do you have a place of business in Ontario?");
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='Owner']")), driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//a[@class='appPanelError appPanelErrorMore']")), driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='First Name must be entered.']")), "First Name", "First Name must be entered.");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Last Name must be entered.']")), "Last Name", "Last Name must be entered.");
//        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Street Name must be entered.']")), "Street Name", "Street Name must be entered.");
//        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Street Number must be entered.']")), "Street Number", "Street Number must be entered.");
//        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='City/Town must be entered.']")), "City/Town", "City/Town must be entered.");
//        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Province must be selected']")), "Province", "Province must be selected");
//        HelperMethods.verifyElementText(driver.findElement(By.xpath("//span[text()='Postal Code must be entered']")), "Postal Code", "Postal Code must be entered");

        HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
        HelperMethods.fluentWaitAndClick(findAddressTextArea, driver);
        HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
        HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE_CR, driver);
        HelperMethods.fluentWaitAndClick(findAddressButton, driver);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_DR, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        Thread.sleep(1000);
        HelperMethods.verifyElementGrey(selectSubmitButton);

    }

    public String getBusinessNameSoleProprietorship() {
        return businessNameSoleProprietorship;
    }

    public void setBusinessNameSoleProprietorship(String businessNameSoleProprietorship) {
        this.businessNameSoleProprietorship = businessNameSoleProprietorship;
    }

    public void completeAddressSameAsAndSave() {
        if ((pageTitle.getText().contains(Config.REGISTER_FIRM_NAME_FOR_ONTARIO_LIMITED_LIABILITY_PARTNERSHIP_TITLE)) || (pageTitle.getText().contains(Config.REGISTER_FIRM_NAME_FOR_EXTRA_PROVINCIAL_LIMITED_LIABILITY_PARTNERSHIP_TITLE))) {
            HelperMethods.fluentWaitAndCheckVisible(placeOfBusinessYes, driver);
            HelperMethods.fluentWaitAndClick(placeOfBusinessYes, driver);
            HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
//            HelperMethods.fluentWaitAndClick(findAddressTextArea, driver);
            HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
            HelperMethods.fluentWaitAndClick(findAddressButton, driver);
            HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
            HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
            if (textAddressOf.getText().contains("[Not Provided]")) {
                HelperMethods.fluentWaitAndClick(editAddress, driver);
                HelperMethods.waitAndSendKeys(streetNumberAddress, "1", driver);

            }
            HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        } else {
            HelperMethods.fluentWaitAndCheckVisible(placeOfBusinessYes, driver);
            HelperMethods.fluentWaitAndClick(placeOfBusinessYes, driver);
            HelperMethods.fluentWaitAndCheckVisible(placeOfBusinessYes, driver);
            HelperMethods.staleElementVisible(saveAndContinue, driver);
            HelperMethods.fluentWaitAndCheckVisible(sameAsCorporationAddress, driver);
            HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        }
    }

    public void completeAddressFileADeceleration() {
        if (HelperMethods.isElementDisplayed(findAddressTextArea, driver)) {
            HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
            HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
            HelperMethods.fluentWaitAndClick(findAddressButton, driver);
            HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
            HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        }
        if (textAddressOf.getText().contains("[Not Provided]")) {
            HelperMethods.fluentWaitAndClick(editAddress, driver);
            HelperMethods.waitAndSendKeys(streetNumberAddress, "1", driver);

        }
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
    }

    public void completeAddressFileArticlesOfAmalgamationAddressSaveAndContinue() throws InterruptedException, AWTException {
//        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver, saveAndContinueButton);
        Thread.sleep(1000);
        //      HelperMethods.robotSendVENTER();
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinueButton, driver);
//        HelperMethods.highLighterMethod(driver, fileArticlesOfAmalgamationAddress);
//        HelperMethods.waitAndClick(fileArticlesOfAmalgamationAddress, driver);
//        Thread.sleep(1000);
//        HelperMethods.waitAndClick(fileArticlesOfAmalgamationAddressEdit, driver);
//        Thread.sleep(1000);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        HelperMethods.highLighterMethod(driver, saveAndContinue);

//        HelperMethods.waitAndClickAction(saveAndContinueAddress, driver);
//        HelperMethods.robotSendTABMultipleTimes(11);
//        Thread.sleep(1000);
//        HelperMethods.robotSendVENTER();
//        Thread.sleep(1000);


        HelperMethods.fluentWaitAndClick(saveAndContinueButton, driver);
//        driver.findElement((By) saveAndContinue).click();
    }

    public void completeAddressAndSave() {
        if (!(pageTitle.getText().equals(Config.INCORPORATE_ONTARIO_BUSINESS_CORPORATION_HEADER))) {
            HelperMethods.fluentWaitAndCheckVisible(placeOfBusinessYes, driver);
            HelperMethods.fluentWaitAndClick(placeOfBusinessYes, driver);
            HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
            HelperMethods.fluentWaitAndClick(findAddressTextArea, driver);
            HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
            HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
            HelperMethods.fluentWaitAndClick(findAddressButton, driver);
            HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
            HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);

            HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        } else {
            HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
            HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
            HelperMethods.fluentWaitAndClick(findAddressButton, driver);
            HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
            HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
            HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        }
    }

    public void completeInternationalBusinessAddressAndSave() throws InterruptedException, AWTException {

        HelperMethods.fluentWaitAndClick(internationalAddressOption, driver);
        Thread.sleep(500);
        HelperMethods.fluentWaitAndClick(internationalAddress, driver);
        HelperMethods.waitAndSendKeys(internationalAddressLine1, Config.INTERNATIONAL_ADDRESS_LINE1, driver);
        HelperMethods.waitAndSendKeys(internationalCityTown, Config.INTERNATIONAL_CITY_TOWN, driver);
        HelperMethods.waitAndSendKeys(internationalPostalCode, Config.INTERNATIONAL_POSTAL_CODE, driver);
        HelperMethods.fluentWaitAndClick(internationalCountry, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//input[@role='searchbox']")), Config.INTERNATIONAL_COUNTRY, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
        //        HelperMethods.fluentWaitAndClick(internationalCountry, driver);
//        Thread.sleep(1000);
//        HelperMethods.waitAndSendKeys(internationalCountrySearchbox, Config.INTERNATIONAL_COUNTRY, driver);
//        Thread.sleep(1000);
//        HelperMethods.robotSendENTER();

//        HelperMethods.robotSendValue(Config.INTERNATIONAL_COUNTRY);
//        HelperMethods.robotSendENTER();
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void completeCRAddressAndSave() throws InterruptedException {
        if (!(pageTitle.getText().equals(Config.INCORPORATE_ONTARIO_BUSINESS_CORPORATION_HEADER))) {
            HelperMethods.fluentWaitAndCheckVisible(placeOfBusinessYes, driver);
            HelperMethods.fluentWaitAndClick(placeOfBusinessYes, driver);
            HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
            HelperMethods.fluentWaitAndClick(findAddressTextArea, driver);
            HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
            HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE_CR, driver);
            HelperMethods.fluentWaitAndClick(findAddressButton, driver);
            HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
            HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
//            HelperMethods.waitAndSendKeys(streetNumberAddress, Config.STREET_NUMBER_VALUE_CR, driver);
            Thread.sleep(1000);
            HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_CR, driver);
            HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        } else {
            HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
            HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE_CR, driver);
            HelperMethods.fluentWaitAndClick(findAddressButton, driver);
            HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
            HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
            HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_CR, driver);
            HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        }
    }

    public void completeSolePropAddressAndSave() throws InterruptedException {
        if (!(pageTitle.getText().equals(Config.INCORPORATE_ONTARIO_BUSINESS_CORPORATION_HEADER))) {
            HelperMethods.fluentWaitAndCheckVisible(placeOfBusinessYes, driver);
            HelperMethods.fluentWaitAndClick(placeOfBusinessYes, driver);
            HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
            HelperMethods.fluentWaitAndClick(findAddressTextArea, driver);
            HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
            HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
            HelperMethods.fluentWaitAndClick(findAddressButton, driver);
            HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
            HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
            Thread.sleep(1000);
            HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_DR, driver);
            HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        } else {
            HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
            HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
            HelperMethods.fluentWaitAndClick(findAddressButton, driver);
            HelperMethods.waitAndSendKeys(streetNumberAddress, "001", driver);
            HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
            HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
            HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        }
    }

    public void completeOnlyAddressAndSave() {
        HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
        HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.fluentWaitAndClick(findAddressButton, driver);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
    }

    public void completeOwnerAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.fluentWaitAndClick(addressSameAsCorporation, driver);
        HelperMethods.staleElementVisible(firstNameField, driver);
        HelperMethods.staleElementVisible(ownerTitle, driver);
        HelperMethods.staleElementVisible(pageTitle, driver);
        HelperMethods.staleElementVisible(lastNameField, driver);

        HelperMethods.staleElementVisible(saveAndContinue, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void completeInternationalAddressOwnerAndSave() throws InterruptedException, AWTException {
        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.fluentWaitAndClick(differentAddress, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndClick(internationalAddress, driver);
        HelperMethods.waitAndSendKeys(internationalAddressLine1, Config.INTERNATIONAL_ADDRESS_LINE1, driver);
        HelperMethods.waitAndSendKeys(internationalCityTown, Config.INTERNATIONAL_CITY_TOWN, driver);
        HelperMethods.waitAndSendKeys(internationalPostalCode, Config.INTERNATIONAL_POSTAL_CODE, driver);
        HelperMethods.fluentWaitAndClick(internationalCountry, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//input[@role='searchbox']")), Config.INTERNATIONAL_COUNTRY, driver);
//        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);

//        HelperMethods.robotSendENTER();

//        HelperMethods.robotSendValue(Config.INTERNATIONAL_COUNTRY);
//        HelperMethods.robotSendENTER();
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void completeAuthorizationAndSave() {
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.fluentWaitAndCheckVisible(soleProprietorOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(authorizationHeading, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }


    public void amendAuthorizationAndSubmit() {
        HelperMethods.fluentWaitAndCheckVisible(amendAuthorization, driver);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HelperMethods.fluentWaitAndClick(amendAuthorization, driver);
        HelperMethods.selectOptionFromDropdownselectByIndex(1, amendSelectFromPartners, driver);
        // HelperMethods.selectOptionFromDropdownWithValueOf("Contact first CONTACT LAST",amendSelectFromPartners, driver );

        HelperMethods.staleElementClick(servicesMenuOption, driver);
     //   HelperMethods.staleElementClick(amendConfirm, driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        HelperMethods.staleElementClick(amendContinue, driver);
        HelperMethods.staleElementClick(amendConfirm, driver);
        HelperMethods.staleElementClick(selectSubmitButton, driver);

    }

    public void selectPartnerAuthorizationSaveAndContinue() {
        HelperMethods.fluentWaitAndCheckVisible(authorizationTabLink, driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndClick(authorizationTabLink, driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// +++++++
//        HelperMethods.waitAndClick(selectFromPartners, driver);
//        HelperMethods.waitAndSendKeys(partnerTextArea, "Contact", driver);
//        HelperMethods.fluentWaitAndCheckVisible(selectFirstPartner, driver);
//        HelperMethods.waitAndClick(selectFirstPartner, driver);
// ++++++++++
        HelperMethods.selectOptionFromDropdownselectByIndex(2, selectFromPartners, driver);
        HelperMethods.selectOptionFromDropdownselectByIndex(2, selectFromPartners, driver);
//         HelperMethods.selectOptionFromDropdownWithValueOf("Contact First CONTACT LAST",selectFromPartners, driver );

//        HelperMethods.selectOptionFromDropdownselectByValue("Contact First CONTACT LAST",selectFromPartners, driver );
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        HelperMethods.selectOptionFromDropdownselectByValue("Contact First CONTACT LAST",selectFromPartners, driver );

        HelperMethods.staleElementClick(saveAndContinue, driver);
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        HelperMethods.staleElementClick(amendSubmit, driver);
    }

    public void amendChangePartners() {
        HelperMethods.fluentWaitAndCheckVisible(amendPartnersTab, driver);
        HelperMethods.fluentWaitAndClick(amendPartnersTab, driver);
        HelperMethods.fluentWaitAndClick(amendPartner1Edit, driver);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("(//span[text()='Attention/Care of'])[2]/following::input")), "Hello Automation", driver);
//        HelperMethods.waitAndSendKeys(amendPartnersStreetNumber, "000002", driver);
        HelperMethods.staleElementClick(amendPartnersDone, driver);
    }

    public void changePrincipalPlaceOfBusinessAndSave() throws InterruptedException {
        if ((pageTitle.getText().contains(Config.REGISTER_FIRM_NAME_FOR_ONTARIO_LIMITED_LIABILITY_PARTNERSHIP_TITLE)) || (pageTitle.getText().contains(Config.BUSINESS_TYPE_EXTRA_PROVINCIAL))) {
            HelperMethods.fluentWaitAndCheckVisible(amendBusinessAddress, driver);
            HelperMethods.staleElementClick(amendBusinessAddress, driver);
            HelperMethods.fluentWaitAndCheckVisible(placeOfBusinessYes, driver);
            HelperMethods.staleElementClick(placeOfBusinessYes, driver);
            HelperMethods.staleElementVisible(placeOfBusinessYes, driver);
            HelperMethods.fluentWaitAndCheckVisible(addressLookupField, driver);
            Thread.sleep(1200);
            HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver); // POSTAL_CODE_VALUE  POSTAL_BREMNER_BLVD
            HelperMethods.staleElementVisible(findAddressButton, driver);
            HelperMethods.staleElementClick(findAddressButton, driver);
//            HelperMethods.staleElementVisible(streetNumberValue, driver);
//            HelperMethods.staleElementVisible(findAddressButton, driver);
//            HelperMethods.staleElementVisible(doneButton, driver);
//            HelperMethods.waitAndSendKeys(streetNumberValue, "351", driver);
            HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
            HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
            HelperMethods.staleElementClick(doneButton, driver);
            HelperMethods.fluentWaitAndCheckVisible(editButton, driver);
        } else {
            HelperMethods.staleElementVisible(amendBusinessAddress, driver);
            HelperMethods.staleElementClick(amendBusinessAddress, driver);
            HelperMethods.fluentWaitAndCheckVisible(placeOfBusinessYes, driver);
            HelperMethods.staleElementClick(placeOfBusinessYes, driver);
            HelperMethods.staleElementVisible(doneButton, driver);
            HelperMethods.staleElementClick(doneButton, driver);
        }
    }

    public void selectPartners() throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(authorizationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(amendBusinessSubmitButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(personAuthorizingOption, driver);
        HelperMethods.staleElementClick(selectFromPartnersDropdown, driver);
        HelperMethods.waitAndSendKeys(partnerTextArea, "Contact", driver);
        HelperMethods.fluentWaitAndCheckVisible(selectFirstPartner, driver);
        HelperMethods.waitAndClick(selectFirstPartner, driver);
        HelperMethods.staleElementVisible(authorizationHeading, driver);
    }

    public void selectFromPartners() throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(selectFromPartners, driver);
        HelperMethods.selectOptionFromDropdownselectByIndex(1, selectFromPartners, driver);
//        HelperMethods.staleElementClick(selectFromPartners, driver);
//        HelperMethods.fluentWaitAndCheckVisible(selectFomPartnersAsContact, driver);
//        HelperMethods.waitAndClick(selectFomPartnersAsContact, driver);
        Thread.sleep(500);
    }

    public void setSelectFromPartnersOption() throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(selectFromPartnersDropdown, driver);
        HelperMethods.staleElementClick(selectFromPartnersDropdown, driver);
        HelperMethods.waitAndSendKeys(partnerTextArea, "Contact", driver);
        HelperMethods.fluentWaitAndCheckVisible(selectFirstPartner, driver);
        HelperMethods.waitAndClick(selectFirstPartner, driver);
    }

    public void selectDirectorsOrOfficers() throws InterruptedException, AWTException {
        Thread.sleep(1000);
        HelperMethods.waitAndClick(DirectorsOrOfficers, driver);
        HelperMethods.fluentWaitAndCheckVisible(personAuthorizingOption, driver);
        HelperMethods.waitAndSendKeys(DirectorsOrOfficersTextArea, "Contact First CONTACT LAST (Director)", driver);
        HelperMethods.fluentWaitAndCheckVisible(selectFirstPartner, driver);
        HelperMethods.waitAndClick(selectFirstPartner, driver);
        Thread.sleep(1500);

    }

    public void updatePrincipalPlaceOfBusiness() throws InterruptedException, AWTException {
        Thread.sleep(100);
        HelperMethods.waitAndClick(updatePrincipalPlaceOfBusinessPlus, driver);
        Thread.sleep(500);
        HelperMethods.waitAndClick(updatePrincipalPlaceOfBusinessPlusYes, driver);
//        HelperMethods.waitAndSendKeys(DirectorsOrOfficersTextArea, "Contact First CONTACT LAST (Director)", driver);
//        HelperMethods.robotSendVENTER();
        Thread.sleep(150);
    }

    public void messageCancellationConfirmationMustBeAccepted() throws InterruptedException {
        Thread.sleep(100);
        if (HelperMethods.fluentWaitAndCheckVisible(messageCancellationConfirmationMustBeAccepted, driver)) {
            HelperMethods.highLighterMethod(driver, messageCancellationConfirmationMustBeAccepted);
            Thread.sleep(1000);
//            HelperMethods.fluentWaitAndCheckVisible(personPersonActingUnderPowerOfAttorney, driver);
//            HelperMethods.fluentWaitAndCheckVisible(personAuthorizingOption, driver);
            partnerSoleProprietorshipRegistrationPage.selectCancelConfirmationCheckBox();
            Thread.sleep(1000);
            partnerSoleProprietorshipRegistrationPage.selectCancelConfirmationCheckBox();
            HelperMethods.staleElementClick(saveAndContinue, driver);
        }
        Thread.sleep(150);
    }

    public void selectPartnersMultiple() throws InterruptedException {
        if ((pageTitle.getText().contains(Config.REGISTER_FIRM_NAME_FOR_ONTARIO_LIMITED_LIABILITY_PARTNERSHIP_TITLE)) || (pageTitle.getText().contains(Config.REGISTER_FIRM_NAME_FOR_EXTRA_PROVINCIAL_LIMITED_LIABILITY_PARTNERSHIP_TITLE))) {
            HelperMethods.fluentWaitAndCheckVisible(authorizationHeading, driver);
            HelperMethods.fluentWaitAndCheckVisible(personAuthorizingOption, driver);
            HelperMethods.staleElementClick(selectFromPartners, driver);
            HelperMethods.selectOptionFromDropdownselectByIndex(1, selectFromPartnersOption, driver);
//            HelperMethods.fluentWaitAndCheckVisible(selectFomPartnersAsContact, driver);
//            HelperMethods.waitAndClick(selectFomPartnersAsContact, driver);
            Thread.sleep(500);

//            HelperMethods.fluentWaitAndCheckVisible(personPersonActingUnderPowerOfAttorney, driver);
//            HelperMethods.fluentWaitAndCheckVisible(personAuthorizingOption, driver);
            HelperMethods.staleElementVisible(authorizationHeading, driver);
            HelperMethods.staleElementClick(saveAndContinue, driver);
//            if (HelperMethods.fluentWaitAndCheckVisible(messageCancellationConfirmationMustBeAccepted, driver)){
//
//            HelperMethods.fluentWaitAndCheckVisible(personPersonActingUnderPowerOfAttorney, driver);
//            HelperMethods.fluentWaitAndCheckVisible(personAuthorizingOption, driver);
//                HelperMethods.staleElementClick(saveAndContinue, driver);
//            }

        } else if (pageTitle.getText().contains(Config.BUSINESS_TYPE_GENERAL_PARTNERSHIP)) {
            HelperMethods.fluentWaitAndCheckVisible(authorizationHeading, driver);
//            HelperMethods.fluentWaitAndCheckVisible(amendBusinessSubmitButton, driver);
            HelperMethods.fluentWaitAndCheckVisible(personAuthorizingOption, driver);
            HelperMethods.staleElementClick(selectFromPartnersDropdown, driver);
            HelperMethods.waitAndSendKeys(partnerTextArea, "Contact", driver);
            HelperMethods.fluentWaitAndCheckVisible(selectFirstPartner, driver);
            HelperMethods.waitAndClick(selectFirstPartner, driver);
            HelperMethods.staleElementVisible(authorizationHeading, driver);
        }
    }

    public void completeAuthorizationForGeneralPartnershipAndSave() throws InterruptedException {
        if ((pageTitle.getText().contains(Config.REGISTER_BUSINESS_NAME_FOR_GENERAL_PARTNERSHIP_HEADER)) || (pageTitle.getText().contains(Config.REGISTER_BUSINESS_NAME_HEADER))) {
            HelperMethods.fluentWaitAndCheckVisible(authorizationHeading, driver);
            HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
            HelperMethods.fluentWaitAndCheckVisible(personAuthorizingOption, driver);
            HelperMethods.waitAndClick(selectFromPartnersDropdownContainer, driver);
            HelperMethods.waitAndSendKeys(partnerTextArea, "Contact", driver);
            HelperMethods.fluentWaitAndCheckVisible(selectFirstPartner, driver);
            HelperMethods.waitAndClick(selectFirstPartner, driver);
            HelperMethods.fluentWaitAndCheckVisible(authorizationHeading, driver);
            Thread.sleep(1500);
            HelperMethods.staleElementClick(saveAndContinue, driver);
        } else {
            HelperMethods.fluentWaitAndCheckVisible(authorizationHeading, driver);
            HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
            HelperMethods.fluentWaitAndCheckVisible(personAuthorizingOption, driver);
//        HelperMethods.waitAndClick(selectFromPartnersOption, driver);
            //   HelperMethods.selectOptionFromDropdownWithValueOf("Contact first CONTACT LAST", selectFromPartnersOption, driver);
            HelperMethods.selectOptionFromDropdownselectByIndex(1, selectFromPartnersOption, driver);
//        HelperMethods.fluentWaitAndClick(partnerOption, driver);
            Thread.sleep(1500);
            HelperMethods.fluentWaitAndCheckVisible(authorizationHeading, driver);
            HelperMethods.staleElementClick(saveAndContinue, driver);
        }
    }

    public void completeAuthorizationAndSaveExtraProvincial() {
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.fluentWaitAndCheckVisible(typeAsIndividualOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(authorizationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
        HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.fluentWaitAndClick(findAddressButton, driver);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.staleElementVisible(typeAsIndividualOption, driver);

        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void renewalConfirmationExtraProvincial() {
        HelperMethods.fluentWaitAndCheckVisible(selectSubmitButton, driver);
        HelperMethods.fluentWaitAndClick(continueUnderBusinessCorporationActCheckBox, driver);
//        HelperMethods.fluentWaitAndCheckVisible(authorizationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
        HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.fluentWaitAndClick(findAddressButton, driver);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.staleElementClick(compliedWithSubSectionCheckBox, driver);

        HelperMethods.staleElementClick(selectSubmitButton, driver);
    }

    public String returnBusinessNumber() throws InterruptedException {
        HelperMethods.staleElementVisible(getBusinessName, driver);
        HelperMethods.highLighterMethod(driver, getBusinessName);
        return getBusinessName.getText();
    }

    public void completeReviewAndSubmit() throws InterruptedException {
        HelperMethods.staleElementVisible(authorizationCheckBox, driver);
        HelperMethods.fluentWaitAndCheckVisible(reviewHeading, driver);
        HelperMethods.staleElementClick(authorizationCheckBox, driver);
        Thread.sleep(2500);
        HelperMethods.fluentWaitAndCheckVisible(submitButton, driver);
        HelperMethods.staleElementVisible(pageTitle, driver);
        HelperMethods.staleElementVisible(authorizationCheckBox, driver);
        Thread.sleep(2500);
        HelperMethods.scrollIntoViewForClick(submitButton, driver);
        HelperMethods.staleElementClick(submitButton, driver);
    }

    public void selectAmendBusinessSubmitButton() throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.staleElementVisible(amendBusinessSubmitButton, driver);
        HelperMethods.staleElementClick(amendBusinessSubmitButton, driver);
    }
// ==========

    public PartnerSoleProprietorshipRegistrationPage searchForABusinessName(String businessName) throws InterruptedException {
        //    String getSearchForABusinessName = searchForABusinessName;
        HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(businessName);
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(searchResults, driver);
        HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
//        return getSearchForABusinessName;
        return this;
    }

    public PartnerSoleProprietorshipRegistrationPage setOntarioLimitedLiabilityPartnershiBusinessExpier(String businessNumberExpiery) throws InterruptedException {
        //String businessNumberExpiery = "FN6LOFFPWA";
        PartnerSoleProprietorshipRegistrationPage artnerSoleProprietorshipRegistrationPage = new PartnerSoleProprietorshipRegistrationPage(driver).searchForABusinessName(businessNumberExpiery);

        HelperMethods.fluentWaitAndCheckVisible(correctTheRegister, driver);
        HelperMethods.highLighterMethod(driver, correctTheRegister);
        HelperMethods.waitAndClick(correctTheRegister, driver);


        HelperMethods.fluentWaitAndCheckVisible(correctVersion, driver);
        HelperMethods.highLighterMethod(driver, correctVersion);
        HelperMethods.waitAndClick(correctVersion, driver);
        Thread.sleep(3000);

        HelperMethods.fluentWaitAndCheckVisible(Registrar, driver);
        HelperMethods.highLighterMethod(driver, Registrar);
        HelperMethods.staleElementClick(Registrar, driver);
        Thread.sleep(3000);
//  Continue
//        HelperMethods.highLighterMethod(driver,driver.findElement(By.cssSelector("input[id*='ChangeDescription']")));
        HelperMethods.fluentWaitAndCheckVisible(changeExpiryDates, driver);
        Thread.sleep(3000);
        HelperMethods.highLighterMethod(driver, paymentConfirmationContinueButton);
        HelperMethods.waitAndSendKeys(changeExpiryDates, "Change Expiry Dates", driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(paymentConfirmationContinueButton, driver);
        Thread.sleep(1000);
//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//DIV[@role=\"dialog\"][1]/DIV[@role=\"alert\"][1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[1]/BUTTON[@role=\"button\"][1]/SPAN[2]")), driver);
//        HelperMethods.staleElementClick(driver.findElement(By.xpath("//DIV[@role=\"dialog\"][1]/DIV[@role=\"alert\"][1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[1]/BUTTON[@role=\"button\"][1]/SPAN[2]")), driver);

//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")), driver);
//        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")));
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")),driver);
        // ++++++++++++++++++++++
//        try {
//            HelperMethods.robotSendTABMultipleTimes(7);
//            Thread.sleep(1000);
//            HelperMethods.robotSendVENTER();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
        // +++++++++++++++++++
//        driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")).click();
        Thread.sleep(3000);
//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath(" //FORM[@id=\"viewInstanceForm\"]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[@role=\"tabpanel\"][1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/INPUT[1]")), driver);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath(" //FORM[@id=\"viewInstanceForm\"]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[@role=\"tabpanel\"][1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/INPUT[1]")),"" ,driver);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath(" //FORM[@id=\"viewInstanceForm\"]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[@role=\"tabpanel\"][1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/INPUT[1]")),"January 26, 2022" ,driver);

        HelperMethods.highLighterMethod(driver, reregistrationDate);
        HelperMethods.highLighterMethod(driver, selectSubmitButton);

        HelperMethods.waitAndSendKeys(reregistrationDate, HelperMethods.getFutureDate(0), driver);

        //       String expieryDay = HelperMethods.getFutureDate(11);
        HelperMethods.highLighterMethod(driver, expiryDate);
        HelperMethods.waitAndSendKeys(expiryDate, HelperMethods.getFutureDate(11), driver);
        Thread.sleep(300);
//        HelperMethods.highLighterMethod(driver,removalReasonCode);
//        HelperMethods.waitAndSendKeys(removalReasonCode,expieryDay ,driver);

//        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")));
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")),driver);

// +++++++++++++++
//        try {
//            HelperMethods.robotSendTABMultipleTimes(12);
//            Thread.sleep(1000);
//
//            HelperMethods.robotSendVENTER();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
// +++++++++++++
        HelperMethods.staleElementClick(selectSubmitButton, driver);
        Thread.sleep(500);
        return this;
    }

    public PartnerSoleProprietorshipRegistrationPage setSoleProprietorshipBusinessExpier(String businessNumberExpiery) throws InterruptedException {
        //String businessNumberExpiery = "FN6LOFFPWA";
        PartnerSoleProprietorshipRegistrationPage artnerSoleProprietorshipRegistrationPage = new PartnerSoleProprietorshipRegistrationPage(driver).searchForABusinessName(businessNumberExpiery);

        HelperMethods.fluentWaitAndCheckVisible(correctTheRegister, driver);
        HelperMethods.highLighterMethod(driver, correctTheRegister);
        HelperMethods.waitAndClick(correctTheRegister, driver);


        HelperMethods.fluentWaitAndCheckVisible(correctVersion, driver);
        HelperMethods.highLighterMethod(driver, correctVersion);
        HelperMethods.waitAndClick(correctVersion, driver);
        Thread.sleep(3000);

        HelperMethods.fluentWaitAndCheckVisible(Registrar, driver);
        HelperMethods.highLighterMethod(driver, Registrar);
        HelperMethods.staleElementClick(Registrar, driver);
        Thread.sleep(3000);
//  Continue
//        HelperMethods.highLighterMethod(driver,driver.findElement(By.cssSelector("input[id*='ChangeDescription']")));
        HelperMethods.fluentWaitAndCheckVisible(changeExpiryDates, driver);
        Thread.sleep(3000);
        HelperMethods.highLighterMethod(driver, paymentConfirmationContinueButton);
//        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//DIV[@role="dialog"][1]/DIV[@role="alert"][1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[3]/DIV[1]/DIV[1]/TEXTAREA[1]")));
        HelperMethods.waitAndSendKeys(changeExpiryDates, "Change Expiry Dates", driver);


//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//DIV[@role=\"dialog\"][1]/DIV[@role=\"alert\"][1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[1]/BUTTON[@role=\"button\"][1]/SPAN[2]")), driver);
//        HelperMethods.staleElementClick(driver.findElement(By.xpath("//DIV[@role=\"dialog\"][1]/DIV[@role=\"alert\"][1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[1]/BUTTON[@role=\"button\"][1]/SPAN[2]")), driver);

//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")), driver);
//        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")));
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")),driver);

// ++++++++++
//        try {
//            HelperMethods.robotSendTABMultipleTimes(7);
//            Thread.sleep(1000);
//            HelperMethods.robotSendVENTER();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
// ++++++++++++++++
        HelperMethods.staleElementClick(paymentConfirmationContinueButton, driver);
//        driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")).click();
        Thread.sleep(3000);
//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath(" //FORM[@id=\"viewInstanceForm\"]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[@role=\"tabpanel\"][1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/INPUT[1]")), driver);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath(" //FORM[@id=\"viewInstanceForm\"]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[@role=\"tabpanel\"][1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/INPUT[1]")),"" ,driver);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath(" //FORM[@id=\"viewInstanceForm\"]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[@role=\"tabpanel\"][1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/INPUT[1]")),"January 26, 2022" ,driver);
        String expieryDay = HelperMethods.getFutureDate(11);

        HelperMethods.highLighterMethod(driver, expiryDate);
        HelperMethods.highLighterMethod(driver, selectSubmitButton);
        HelperMethods.waitAndSendKeys(expiryDate, expieryDay, driver);
//                HelperMethods.highLighterMethod(driver,expiryDate);
//        HelperMethods.waitAndSendKeys(expiryDate,expieryDay ,driver);


        Thread.sleep(300);
//        HelperMethods.highLighterMethod(driver,removalReasonCode);
//        HelperMethods.waitAndSendKeys(removalReasonCode,expieryDay ,driver);

//        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")));
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")),driver);

// +++++++++++++++++
//        try {
//            HelperMethods.robotSendTABMultipleTimes(7);
//            Thread.sleep(1000);
//            HelperMethods.robotSendVENTER();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
// ++++++++++++++++

        HelperMethods.staleElementClick(selectSubmitButton, driver);
        Thread.sleep(500);
        return this;
    }

    public PartnerSoleProprietorshipRegistrationPage setPartnershipshipBusinessExpier(String businessNumberExpiery) throws InterruptedException {
        //String businessNumberExpiery = "FN6LOFFPWA";
        PartnerSoleProprietorshipRegistrationPage artnerSoleProprietorshipRegistrationPage = new PartnerSoleProprietorshipRegistrationPage(driver).searchForABusinessName(businessNumberExpiery);

        HelperMethods.fluentWaitAndCheckVisible(correctTheRegister, driver);
        HelperMethods.highLighterMethod(driver, correctTheRegister);
        HelperMethods.waitAndClick(correctTheRegister, driver);


        HelperMethods.fluentWaitAndCheckVisible(correctVersion, driver);
        HelperMethods.highLighterMethod(driver, correctVersion);
        HelperMethods.waitAndClick(correctVersion, driver);
        Thread.sleep(3000);

        HelperMethods.fluentWaitAndCheckVisible(Registrar, driver);
        HelperMethods.highLighterMethod(driver, Registrar);
        HelperMethods.staleElementClick(Registrar, driver);
        Thread.sleep(3000);
//  Continue
//        HelperMethods.highLighterMethod(driver,driver.findElement(By.cssSelector("input[id*='ChangeDescription']")));
        HelperMethods.fluentWaitAndCheckVisible(changeExpiryDates, driver);
        HelperMethods.highLighterMethod(driver, paymentConfirmationContinueButton);
        Thread.sleep(3000);
//        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//DIV[@role="dialog"][1]/DIV[@role="alert"][1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[3]/DIV[1]/DIV[1]/TEXTAREA[1]")));
        HelperMethods.waitAndSendKeys(changeExpiryDates, "Change Expiry Dates", driver);


//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//DIV[@role=\"dialog\"][1]/DIV[@role=\"alert\"][1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[1]/BUTTON[@role=\"button\"][1]/SPAN[2]")), driver);
//        HelperMethods.staleElementClick(driver.findElement(By.xpath("//DIV[@role=\"dialog\"][1]/DIV[@role=\"alert\"][1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[1]/BUTTON[@role=\"button\"][1]/SPAN[2]")), driver);

//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")), driver);
//        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")));
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")),driver);
//        try {
//            HelperMethods.robotSendTABMultipleTimes(7);
//            Thread.sleep(1000);
//            HelperMethods.robotSendVENTER();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//        driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")).click();
        HelperMethods.staleElementClick(paymentConfirmationContinueButton, driver);
        Thread.sleep(3000);
//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath(" //FORM[@id=\"viewInstanceForm\"]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[@role=\"tabpanel\"][1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/INPUT[1]")), driver);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath(" //FORM[@id=\"viewInstanceForm\"]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[@role=\"tabpanel\"][1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/INPUT[1]")),"" ,driver);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath(" //FORM[@id=\"viewInstanceForm\"]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[@role=\"tabpanel\"][1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/INPUT[1]")),"January 26, 2022" ,driver);

        HelperMethods.highLighterMethod(driver, reregistrationDate);
        HelperMethods.highLighterMethod(driver, selectSubmitButton);
        HelperMethods.waitAndSendKeys(reregistrationDate, HelperMethods.getFutureDate(0), driver);

        //       String expieryDay = HelperMethods.getFutureDate(11);
        HelperMethods.highLighterMethod(driver, expiryDate);
        HelperMethods.waitAndSendKeys(expiryDate, HelperMethods.getFutureDate(11), driver);
        Thread.sleep(300);
//        HelperMethods.highLighterMethod(driver,removalReasonCode);
//        HelperMethods.waitAndSendKeys(removalReasonCode,expieryDay ,driver);

//        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")));
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")),driver);
//        try {
//            HelperMethods.robotSendTABMultipleTimes(14);
//            Thread.sleep(1000);
//
//            HelperMethods.robotSendVENTER();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
        HelperMethods.staleElementClick(selectSubmitButton, driver);
        Thread.sleep(500);
        return this;
    }

    public PartnerSoleProprietorshipRegistrationPage ExtraProvincialLimitedLiabilityCompanyName(String businessNumberExpiery) throws InterruptedException {
        //String businessNumberExpiery = "FN6LOFFPWA";
        PartnerSoleProprietorshipRegistrationPage artnerSoleProprietorshipRegistrationPage = new PartnerSoleProprietorshipRegistrationPage(driver).searchForABusinessName(businessNumberExpiery);

        HelperMethods.fluentWaitAndCheckVisible(correctTheRegister, driver);
        HelperMethods.highLighterMethod(driver, correctTheRegister);
        HelperMethods.waitAndClick(correctTheRegister, driver);


        HelperMethods.fluentWaitAndCheckVisible(correctVersion, driver);
        HelperMethods.highLighterMethod(driver, correctVersion);
        HelperMethods.waitAndClick(correctVersion, driver);
        Thread.sleep(3000);

        HelperMethods.fluentWaitAndCheckVisible(Registrar, driver);
        HelperMethods.highLighterMethod(driver, Registrar);
        HelperMethods.staleElementClick(Registrar, driver);
        Thread.sleep(3000);
//  Continue
//        HelperMethods.highLighterMethod(driver,driver.findElement(By.cssSelector("input[id*='ChangeDescription']")));
        HelperMethods.fluentWaitAndCheckVisible(changeExpiryDates, driver);
        HelperMethods.highLighterMethod(driver, paymentConfirmationContinueButton);
        Thread.sleep(3000);
//        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//DIV[@role="dialog"][1]/DIV[@role="alert"][1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[3]/DIV[1]/DIV[1]/TEXTAREA[1]")));
        HelperMethods.waitAndSendKeys(changeExpiryDates, "Change Expiry Dates", driver);

        Thread.sleep(1000);
//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//DIV[@role=\"dialog\"][1]/DIV[@role=\"alert\"][1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[1]/BUTTON[@role=\"button\"][1]/SPAN[2]")), driver);
//        HelperMethods.staleElementClick(driver.findElement(By.xpath("//DIV[@role=\"dialog\"][1]/DIV[@role=\"alert\"][1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[1]/BUTTON[@role=\"button\"][1]/SPAN[2]")), driver);

//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")), driver);
//        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")));
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")),driver);
//        try {
//            HelperMethods.robotSendTABMultipleTimes(7);
//            Thread.sleep(1000);
//            HelperMethods.robotSendVENTER();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
        HelperMethods.staleElementClick(paymentConfirmationContinueButton, driver);
//        driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")).click();
        Thread.sleep(3000);
//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath(" //FORM[@id=\"viewInstanceForm\"]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[@role=\"tabpanel\"][1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/INPUT[1]")), driver);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath(" //FORM[@id=\"viewInstanceForm\"]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[@role=\"tabpanel\"][1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/INPUT[1]")),"" ,driver);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath(" //FORM[@id=\"viewInstanceForm\"]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[@role=\"tabpanel\"][1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/INPUT[1]")),"January 26, 2022" ,driver);

        HelperMethods.highLighterMethod(driver, reregistrationDate);
        HelperMethods.highLighterMethod(driver, selectSubmitButton);
        HelperMethods.waitAndSendKeys(reregistrationDate, HelperMethods.getFutureDate(0), driver);

        //       String expieryDay = HelperMethods.getFutureDate(11);
        HelperMethods.highLighterMethod(driver, expiryDate);
        HelperMethods.waitAndSendKeys(expiryDate, HelperMethods.getFutureDate(11), driver);
        Thread.sleep(300);
//        HelperMethods.highLighterMethod(driver,removalReasonCode);
//        HelperMethods.waitAndSendKeys(removalReasonCode,expieryDay ,driver);

//        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")));
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")),driver);
//        try {
//            HelperMethods.robotSendTABMultipleTimes(13);
//            Thread.sleep(1000);
//            HelperMethods.robotSendVENTER();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
        HelperMethods.staleElementClick(selectSubmitButton, driver);
        Thread.sleep(500);
        return this;
    }


    public boolean soleProprietorshipIsRegistered() {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(getBusinessNameSoleProprietorship());
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchResults, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
        isCorrect = isCorrect && HelperMethods.compareText(searchStatus, Config.STATUS_ACTIVE, logger);
        isCorrect = isCorrect && HelperMethods.compareText(searchBusinessType, Config.BUSINESS_TYPE_SOLE_PROPRIETORSHIP, logger);
        logger.warn("Business name and number is: " + businessNameValue.getText());
        Reporter.log("Business name and number is: " + businessNameValue.getText());
        return isCorrect;
    }

    public boolean extraProvincialIsRegistered() {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(getBusinessNameSoleProprietorship());
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchResults, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
        isCorrect = isCorrect && HelperMethods.compareText(searchStatus, Config.STATUS_ACTIVE, logger);
        isCorrect = isCorrect && HelperMethods.compareText(searchBusinessType, Config.BUSINESS_TYPE_EXTRA_PROVINCIAL, logger);
        logger.warn("Business name and number is: " + businessNameValue.getText());
        Reporter.log("Business name and number is: " + businessNameValue.getText());
        return isCorrect;
    }

    public void completeThreePartnersAndSave() throws InterruptedException, AWTException {

        HelperMethods.fluentWaitAndCheckVisible(numberOfPartnersField, driver);
        //  HelperMethods.waitAndSendKeys(numberOfPartnersField, "3", driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.staleElementVisible(addPartnerDropdown, driver);
        HelperMethods.waitAndClick(addPartnerDropdown, driver);

        HelperMethods.fluentWaitAndCheckVisible(partnerAsIndividualOption, driver);
        HelperMethods.waitAndClick(partnerAsIndividualOption, driver);

        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
        HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.fluentWaitAndClick(findAddressButton, driver);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.staleElementVisible(firstNameField, driver);
        HelperMethods.staleElementVisible(doneButton, driver);
        HelperMethods.waitAndClick(doneButton, driver);

        // 2nd partner USA
        Thread.sleep(2500);
        HelperMethods.staleElementVisible(addPartnerDropdownOption, driver);
        HelperMethods.waitAndClick(addPartnerDropdownOption, driver);

        HelperMethods.fluentWaitAndCheckVisible(partnerAsIndividualOption, driver);
        HelperMethods.waitAndClick(partnerAsIndividualOption, driver);

        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.USA_CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.USA_CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndClick(SelectUSAddress, driver);
        HelperMethods.waitAndSendKeys(internationalAddressLine1, Config.USA_STREET_NUMBER_VALUE_CR + " " + Config.USA_STREET_NAME_VALUE_CR, driver);
        HelperMethods.waitAndSendKeys(internationalCityTown, Config.USA_CITY_VALUE_CR, driver);
        HelperMethods.waitAndClick(SelectUSAState, driver);


        HelperMethods.waitAndSendKeys(governingJurisdictionSearchArea, Config.USA_STATE_VALUE_CR, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
        Thread.sleep(1000);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);

//        HelperMethods.robotSendENTER();

        HelperMethods.waitAndSendKeys(SelectUSAZipCode, Config.USA_ZIP_CODE_VALUE_CR, driver);
        HelperMethods.staleElementVisible(doneButton, driver);
        HelperMethods.waitAndClick(doneButton, driver);
        Thread.sleep(2000);
        // 3rd partner International
        HelperMethods.staleElementVisible(addPartnerDropdown, driver);
        HelperMethods.waitAndClick(addPartnerDropdown, driver);

        HelperMethods.fluentWaitAndCheckVisible(partnerAsIndividualOption, driver);
        HelperMethods.waitAndClick(partnerAsIndividualOption, driver);

        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.INTER_CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.INTER_CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.fluentWaitAndClick(internationalAddress, driver);
        HelperMethods.waitAndSendKeys(internationalAddressLine1, Config.INTERNATIONAL_ADDRESS_LINE1, driver);
        HelperMethods.waitAndSendKeys(internationalCityTown, Config.INTERNATIONAL_CITY_TOWN, driver);
        HelperMethods.waitAndSendKeys(internationalPostalCode, Config.INTERNATIONAL_POSTAL_CODE, driver);
        HelperMethods.fluentWaitAndClick(internationalCountry, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//input[@role='searchbox']")), Config.INTERNATIONAL_COUNTRY, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
        Thread.sleep(1000);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
//        HelperMethods.fluentWaitAndClick(internationalCountry, driver);
//        HelperMethods.robotSendValue(Config.INTERNATIONAL_COUNTRY);
//        HelperMethods.robotSendENTER();
        HelperMethods.staleElementVisible(doneButton, driver);
        Thread.sleep(500);
        HelperMethods.waitAndClick(doneButton, driver);
        Thread.sleep(500);
//        HelperMethods.highLighterMethod(driver,numberOfPartnersField);
//        HelperMethods.waitAndSendKeys(numberOfPartnersField, "3", driver);
//        HelperMethods.fluentLongWaitAndCheckVisible(saveAndContinue, driver);
//        HelperMethods.waitAndClickAction(saveAndContinue, driver);
//
//        HelperMethods.staleElementVisible(addPartnerDropdown, driver);
//        HelperMethods.staleElementVisible(removeLink, driver);
//
//        HelperMethods.waitAndClick(addPartnerDropdown, driver);
//        HelperMethods.waitAndClick(partnerAsIndividualOption, driver);
//        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
//        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
//        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
//        HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
//        HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
//        HelperMethods.fluentWaitAndClick(findAddressButton, driver);
//        HelperMethods.staleElementVisible(firstNameField, driver);
//        HelperMethods.staleElementVisible(doneButton, driver);
//        HelperMethods.waitAndClick(doneButton, driver);
//        HelperMethods.staleElementVisible(addPartnerDropdown, driver);
//        HelperMethods.staleElementVisible(removeLink, driver);
        HelperMethods.staleElementVisible(pageTitle, driver);
//        HelperMethods.staleElementVisible(partnerTwoLabel, driver);
        HelperMethods.staleElementVisible(numberOfPartnersField, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(numberOfPartnersField, "3", driver);
        Thread.sleep(1000);
        HelperMethods.staleElementVisible(addPartnerDropdown, driver);
        HelperMethods.staleElementVisible(removeLink, driver);
//        HelperMethods.staleElementVisible(partnersHeading, driver);
        HelperMethods.staleElementVisible(pageTitle, driver);
//        HelperMethods.staleElementVisible(partnerTwoLabel, driver);
        HelperMethods.staleElementVisible(numberOfPartnersField, driver);
        HelperMethods.fluentLongWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.waitAndClickAction(saveAndContinue, driver);
        Thread.sleep(2900);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void completePartnersAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(numberOfPartnersField, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.staleElementVisible(addPartnerDropdown, driver);
        HelperMethods.waitAndClick(addPartnerDropdown, driver);

        HelperMethods.fluentWaitAndCheckVisible(partnerAsIndividualOption, driver);
        HelperMethods.waitAndClick(partnerAsIndividualOption, driver);

        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
        HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.fluentWaitAndClick(findAddressButton, driver);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.staleElementVisible(firstNameField, driver);
        HelperMethods.staleElementVisible(doneButton, driver);
        HelperMethods.waitAndClick(doneButton, driver);

        HelperMethods.staleElementVisible(addPartnerDropdown, driver);
        HelperMethods.staleElementVisible(removeLink, driver);

        HelperMethods.waitAndClick(addPartnerDropdown, driver);
        HelperMethods.waitAndClick(partnerAsIndividualOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
        HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.fluentWaitAndClick(findAddressButton, driver);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.staleElementVisible(firstNameField, driver);
        HelperMethods.staleElementVisible(doneButton, driver);
        HelperMethods.waitAndClick(doneButton, driver);
        HelperMethods.staleElementVisible(addPartnerDropdown, driver);
        HelperMethods.staleElementVisible(removeLink, driver);
        HelperMethods.staleElementVisible(pageTitle, driver);
//        HelperMethods.staleElementVisible(partnerTwoLabel, driver);
        HelperMethods.staleElementVisible(numberOfPartnersField, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(numberOfPartnersField, "2", driver);
        Thread.sleep(1000);
        HelperMethods.staleElementVisible(addPartnerDropdown, driver);
        HelperMethods.staleElementVisible(removeLink, driver);
//        HelperMethods.staleElementVisible(partnersHeading, driver);
        HelperMethods.staleElementVisible(pageTitle, driver);
//        HelperMethods.staleElementVisible(partnerTwoLabel, driver);
        HelperMethods.staleElementVisible(numberOfPartnersField, driver);
        HelperMethods.fluentLongWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.waitAndClickAction(saveAndContinue, driver);
        Thread.sleep(2900);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void requestCertificateOfStatus() throws InterruptedException, AWTException {
        Thread.sleep(2000);
        Thread.sleep(800);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Request Search Products']")), driver);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//span[text()='Request Search Products']")));
        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[text()='Request Search Products']")), driver);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Request Certificate of Status']")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[text()='Request Certificate of Status']")), driver);

        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndClick(selectSubmitButton, driver);
    }
    public boolean requestCertificateOfStatusEmail() throws InterruptedException, AWTException {

        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//*[@id=\"flashContent\"]")), driver);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//*[@id=\"flashContent\"]")));
        logger.warn("Request Certificate Of Status Email confirmation Message: " + driver.findElement(By.xpath("//*[@id=\"flashContent\"]")).getText());
        Reporter.log("Request Certificate Of Status Email confirmation Message: " + driver.findElement(By.xpath("//*[@id=\"flashContent\"]")).getText()+ "\n");
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(text(), 'Ok')]")), driver);
        return isCorrect;
    }
    public boolean fileFinalPlanForArrangementVerification() throws InterruptedException {

        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);

        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(fileADeclarationFiling, driver);
        HelperMethods.staleElementClick(fileADeclarationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("Particulars of BCA - Articles of Incorporation is :" + bCAArticlesOfIncorporation.getText());
        Reporter.log("Particulars of BCA - Articles of Incorporation is :" + bCAArticlesOfIncorporation.getText());
        HelperMethods.writeToCSV("REG_BCAM008_FileFinalPlanForArrangement", bCAArticlesOfIncorporation.getText());
        String oCN = transactionNumberValue.getText();
        logger.warn("Transaction Number is :" + oCN);
        Reporter.log("Transaction Number is :" + oCN);
        Thread.sleep(2900);
        return isCorrect;
    }
    public boolean reviveAnOntarioBusinessCorporationVerification() throws InterruptedException {

        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
//        HelperMethods.staleElementVisible(makeChangesMenuOption, driver);
        HelperMethods.highLighterMethod(driver, filingsOption);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(filingsOption, driver);

        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(fileADeclarationFiling, driver);
        Thread.sleep(15000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Registrar Notice of Change of Status']")), driver);
//        driver.findElement(By.xpath("//a[@class='appFilingOpen']//span")).click();
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//a[@class='appFilingOpen']//span")), driver);
        Thread.sleep(5000);
        HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("Particulars of Registrar Notice of Change of Status :" + bCAArticlesOfIncorporation.getText());
        Reporter.log("Particulars of Registrar Notice of Change of Status :" + bCAArticlesOfIncorporation.getText());
//        HelperMethods.writeToCSV("REG_NFPCM011_NFPCA_ReviveNotForProfitCorporation", bCAArticlesOfIncorporation.getText());

        logger.warn("Transaction Number is :" + transactionNumberValue.getText());
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
        Thread.sleep(2900);
        return isCorrect;
    }
    public boolean reviveAnNFPCA_FileDraftPlanOfArrangement() throws InterruptedException {

        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
//        HelperMethods.staleElementVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);

        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(fileADeclarationFiling, driver);
        Thread.sleep(15000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//a[@class='appFilingOpen']//span")), driver);
//        driver.findElement(By.xpath("//a[@class='appFilingOpen']//span")).click();
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//a[@class='appFilingOpen']//span")), driver);
        Thread.sleep(5000);
        HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("Particulars of NFPCA - Articles of Arrangement - Draft Filing :" + bCAArticlesOfIncorporation.getText());
        Reporter.log("PParticulars of NFPCA - Articles of Arrangement - Draft Filing :" + bCAArticlesOfIncorporation.getText());

        logger.warn("Transaction Number is :" + transactionNumberValue.getText());
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
        // Write data to CSV
        Thread.sleep(2900);
        return isCorrect;
    }
    public boolean reviveAnNFPCA_ARTICLES_OF_ARRANGEMENT() throws InterruptedException {

        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
//        HelperMethods.staleElementVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);

        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(fileADeclarationFiling, driver);
        Thread.sleep(15000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//a[@class='appFilingOpen']//span")), driver);
//        driver.findElement(By.xpath("//a[@class='appFilingOpen']//span")).click();
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//a[@class='appFilingOpen']//span")), driver);
        Thread.sleep(5000);
        HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("Particulars of NFPCA – Articles of Arrangement :" + bCAArticlesOfIncorporation.getText());
        Reporter.log("Particulars of NFPCA – Articles of Arrangement :" + bCAArticlesOfIncorporation.getText());

        logger.warn("Transaction Number is :" + transactionNumberValue.getText());
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
        Thread.sleep(2900);
        return isCorrect;
    }
    public void requestProfileReport() throws InterruptedException, AWTException {
        Thread.sleep(2000);
        HelperMethods.highLighterMethod(driver,requestSearchProductsMenu);
       HelperMethods.fluentWaitAndCheckVisible(requestSearchProductsMenu, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndClick(requestSearchProductsMenu, driver);
        HelperMethods.fluentWaitAndCheckVisible(requestProfileReport, driver);
        HelperMethods.fluentWaitAndClick(requestProfileReport, driver);
//        HelperMethods.fluentWaitAndCheckVisible(requestSearchProductsMenu, driver);
//        HelperMethods.highLighterMethod(driver, requestSearchProductsMenu);
//        Thread.sleep(5000);
//        HelperMethods.fluentWaitAndCheckVisible(requestProfileReport, driver);
        HelperMethods.fluentWaitAndClick(currentReport, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.EMAIL, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.EMAIL, driver);
//        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_EMAIL_VALUE, driver);
//        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        Thread.sleep(7000);
        HelperMethods.fluentWaitAndClick(selectSubmitButton, driver);
    }

    public boolean requestProfileReportEmail() throws InterruptedException, AWTException {
//        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//*[@id=\"flashContent\"]")));
//        logger.warn("flashDialog name and number is: " + driver.findElement(By.xpath("//*[@id=\"flashContent\"]")).getText());
//        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//span[contains(text(), 'Ok')]")));
//        logger.warn("Ok button and number is: " + driver.findElement(By.xpath("//span[contains(text(), 'Ok')]")).getText());
//        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//*[@id=\"ui-id-1\"]/h2")));
//        logger.warn("ui-id-1 name and number is: " + driver.findElement(By.xpath("//*[@id=\"ui-id-1\"]/h2")).getText());
//        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//*[@id=\"flashDialog\"]")));
//        logger.warn("flashDialog name and number is: " + driver.findElement(By.xpath("//*[@id=\"flashDialog\"]")).getText());
//        HelperMethods.switchWindow(driver);
//        Thread.sleep(1000);
//        HelperMethods.highLighterMethod(driver,flashOkButton);
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//*[@id=\"flashContent\"]")), driver);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//*[@id=\"flashContent\"]")));
        logger.warn("Request Profile Report Email confirmation Message: " + driver.findElement(By.xpath("//*[@id=\"flashContent\"]")).getText());
        Reporter.log("Request Profile Report Email confirmation Message: " + driver.findElement(By.xpath("//*[@id=\"flashContent\"]")).getText()+ "\n");
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(text(), 'Ok')]")), driver);
        return isCorrect;
    }


    public boolean generalPartnershipIsRegistered() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(getBusinessNameSoleProprietorship());
        Thread.sleep(500);
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchResults, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
        isCorrect = isCorrect && HelperMethods.compareText(searchStatus, Config.STATUS_ACTIVE, logger);
        isCorrect = isCorrect && HelperMethods.compareText(searchBusinessType, Config.BUSINESS_TYPE_GENERAL_PARTNERSHIP, logger);
        logger.warn("Business name and number is: " + businessNameValue.getText());
        Reporter.log("Business name and number is: " + businessNameValue.getText());
        return isCorrect;
    }
    public boolean extraProvincialLimitedLiabilityCompanyIsRegistered(String getBusinessName) throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//button[contains(@class,'searchButton appIconSearch')]")), driver);
        driver.findElement(By.xpath("//span[text()='Name or Identifier']/following::input")).sendKeys(getBusinessName);
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//button[contains(@class,'searchButton appIconSearch')]")), driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
        isCorrect = isCorrect && HelperMethods.compareText(searchStatus, Config.STATUS_ACTIVE, logger);
        isCorrect = isCorrect && HelperMethods.compareText(searchBusinessType, Config.ONTARIO_LIMITED_PARTNERSHIP_LABEL, logger);
        logger.warn("Business name and number is: " + businessNameValue.getText());
        Reporter.log("Business name and number is: " + businessNameValue.getText());
        HelperMethods.staleElementClick(businessNameValue, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        HelperMethods.staleElementClick(fileADeclarationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }
    public boolean ontarioLimitedPartnershipIsRegistered() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(getBusinessNameSoleProprietorship());
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchResults, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
        isCorrect = isCorrect && HelperMethods.compareText(searchStatus, Config.STATUS_ACTIVE, logger);
        isCorrect = isCorrect && HelperMethods.compareText(searchBusinessType, Config.ONTARIO_LIMITED_PARTNERSHIP_LABEL, logger);
        logger.warn("Business name and number is: " + businessNameValue.getText());
        Reporter.log("Business name and number is: " + businessNameValue.getText());
        HelperMethods.staleElementClick(businessNameValue, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        HelperMethods.staleElementClick(fileADeclarationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }
    public String getOntarioLimitedPartnershipIsRegistered() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(getBusinessNameSoleProprietorship());
        HelperMethods.fluentWaitAndClick(searchButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        System.out.println(getBusinessNameSoleProprietorship());
        driver.findElement(By.id("QueryString")).sendKeys(getBusinessNameSoleProprietorship());
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        Reporter.log("Business name of OntarioLimitedPartnershipIsRegistered is: " + businessNameValue.getText());
        Thread.sleep(2900);
        return businessNameValue.getText();
    }
    public boolean extraProvincialLimitedPartnershipIsRegistered() {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(getBusinessNameSoleProprietorship());
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchResults, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
        isCorrect = isCorrect && HelperMethods.compareText(searchStatus, Config.STATUS_ACTIVE, logger);
        isCorrect = isCorrect && HelperMethods.compareText(searchBusinessType, Config.EXTRA_PROVINCIAL_LIMITED_PARTNERSHIP_LABEL, logger);
        logger.warn("Business name and number is: " + businessNameValue.getText());
        Reporter.log("Business name and number is: " + businessNameValue.getText());
        return isCorrect;
    }
    public boolean CorporationsAssignAnOCNIsRegistered(String businessName) {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.xpath("//span[text()='Search For']/following::input")).sendKeys(businessName);
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchResults, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
        isCorrect = isCorrect && HelperMethods.compareText(searchStatus, Config.STATUS_ACTIVE, logger);
        isCorrect = isCorrect && HelperMethods.compareText(searchBusinessType, "Business Name - Corporation", logger);
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//*[contains(text(),'" +  businessNameValue.getText() + "')]")));

        logger.warn("Business name and number is: " + businessNameValue.getText());
        Reporter.log("Business name and number is: " + businessNameValue.getText());
        HelperMethods.staleElementClick( driver.findElement(By.xpath("//*[contains(text(),'" +  businessNameValue.getText() + "')]")), driver);
//        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[contains(@class,'appTabs viewGeneralPartnership-tabBox')]")));
        Reporter.log("Business name details: " + driver.findElement(By.xpath("(//div[@class='appAttrValue'])[2]")).getText() + "\n");

        return isCorrect;
    }
    public boolean businessNameCorporationIsRegistered(String businessName) {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.xpath("//span[text()='Search For']/following::input")).sendKeys(businessName);
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchResults, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
        isCorrect = isCorrect && HelperMethods.compareText(searchStatus, Config.STATUS_ACTIVE, logger);
        isCorrect = isCorrect && HelperMethods.compareText(searchBusinessType, "Business Name - Corporation", logger);
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//*[contains(text(),'" +  businessNameValue.getText() + "')]")));

        logger.warn("Business name and number is: " + businessNameValue.getText());
        Reporter.log("Business name and number is: " + businessNameValue.getText());
        HelperMethods.staleElementClick( driver.findElement(By.xpath("//*[contains(text(),'" +  businessNameValue.getText() + "')]")), driver);
//        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[contains(@class,'appTabs viewGeneralPartnership-tabBox')]")));
        Reporter.log("Business name details: " + driver.findElement(By.xpath("(//div[@class='appAttrValue'])[2]")).getText() + "\n");

        return isCorrect;
    }
    public boolean businessNameGeneralPartnershipIsRegistered(String businessName) {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.xpath("//span[text()='Search For']/following::input")).sendKeys(businessName);
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchResults, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
        isCorrect = isCorrect && HelperMethods.compareText(searchStatus, Config.STATUS_ACTIVE, logger);
        isCorrect = isCorrect && HelperMethods.compareText(searchBusinessType, "Business Name - General Partnership", logger);
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//*[contains(text(),'" +  businessNameValue.getText() + "')]")));

        logger.warn("Business name and number is: " + businessNameValue.getText());
        Reporter.log("Business name and number is: " + businessNameValue.getText());
        HelperMethods.staleElementClick( driver.findElement(By.xpath("//*[contains(text(),'" +  businessNameValue.getText() + "')]")), driver);
//        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[contains(@class,'appTabs viewGeneralPartnership-tabBox')]")));
        Reporter.log("Business name details: " + driver.findElement(By.xpath("(//div[@class='appAttrValue'])[2]")).getText() + "\n");

        return isCorrect;
    }
    public boolean extraGeneralPartnershippIsRegistered() {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(getBusinessNameSoleProprietorship());
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchResults, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
        isCorrect = isCorrect && HelperMethods.compareText(searchStatus, Config.STATUS_ACTIVE, logger);
        isCorrect = isCorrect && HelperMethods.compareText(searchBusinessType, "General Partnership", logger);
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//*[contains(text(),'" +  businessNameValue.getText() + "')]")));

        logger.warn("Business name and number is: " + businessNameValue.getText());
        Reporter.log("Business name and number is: " + businessNameValue.getText());
        HelperMethods.staleElementClick( driver.findElement(By.xpath("//*[contains(text(),'" +  businessNameValue.getText() + "')]")), driver);
//        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[contains(@class,'appTabs viewGeneralPartnership-tabBox')]")));
        Reporter.log("Business name details: " + driver.findElement(By.xpath("//div[contains(@class,'appTabs viewGeneralPartnership-tabBox')]")).getText() + "\n");

        return isCorrect;
    }

    public String updateCorporationNameAndSave(String browser) throws InterruptedException {
        String randomUpdatedBusinessName = HelperMethods.randomString();
        logger.warn("Updated Business corporation name is: " + randomUpdatedBusinessName);
        Reporter.log("Updated Business corporation name is: " + randomUpdatedBusinessName);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameValue, driver);
        HelperMethods.waitAndSendKeys(corporationNameValue, randomUpdatedBusinessName, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
        Thread.sleep(1200);
        HelperMethods.staleElementVisible(corporationNameValue, driver);
        HelperMethods.staleElementVisible(checkNameButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);

        return randomUpdatedBusinessName;
    }

    public String updateBusinessName(String browser) throws InterruptedException {
        String randomUpdatedBusinessName = HelperMethods.randomString();
        logger.warn("Updated Business corporation name is: " + randomUpdatedBusinessName);
        Reporter.log("Updated Business corporation name is: " + randomUpdatedBusinessName);
        HelperMethods.fluentWaitAndCheckVisible(proposedBusinessNameField, driver);
        HelperMethods.waitAndSendKeys(proposedBusinessNameField, randomUpdatedBusinessName, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
        Thread.sleep(1200);
        HelperMethods.staleElementVisible(proposedBusinessNameField, driver);
        HelperMethods.staleElementVisible(checkNameButton, driver);
        return randomUpdatedBusinessName;
    }

    public String completeCorporationNameAndSave(String browser) throws InterruptedException {
//        String randomBusinessName = HelperMethods.randomString() + " inc.";
        String randomCorporationName = HelperMethods.randomString() + HelperMethods.generateRandomNumber(9999,1111)+ " test inc.";
//        logger.warn("Business name is: " + randomBusinessName);
//        Reporter.log("Business name is: " + randomBusinessName);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(willThisCorporationHaveNumberNameNoButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.waitAndClick(willThisCorporationHaveNumberNameNoButton, driver);
            Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(willThisCorporationHaveNumberNameNoButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.waitAndClick(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameValue, driver);

        HelperMethods.createNewTabAndStayFocused(driver);

//        driver.get("https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomBusinessName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next");
//        Thread.sleep(1500);
//        HelperMethods.createNewTabAndStayFocused(driver);
//        Thread.sleep(3500);
//        driver.get("https://www-pre.nuans.com/app/scr/corp/nuans/xml/activeReports.xml");
//        Thread.sleep(3500);
//        driver.getWindowHandle();
//
//        if (browser.equals("chrome")) {
//            HelperMethods.highLighterMethod(driver,nuansReportNumber); // Nov 12, 2021 - Added highLighterMethod to highlight the object before select
//            String reportNumber = nuansReportNumber.getText();
//            logger.warn("Report number is: " + reportNumber);
//            String reportTitle = nuansReportTitle.getText();
//            logger.warn("Report title is: " + reportTitle);
//            HelperMethods.switchWindow(driver);
//
//            HelperMethods.waitAndSendKeys(corporationNameValue, reportTitle, driver);
//            HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber, driver);
//        } else if (browser.equals("firefox")) {
//            String reportNumber = nuansReportNumberFirefox.getText();
//            logger.warn("Report number is: " + reportNumber);
//            String reportTitle = nuansReportTitleFirefox.getText();
//            logger.warn("Report title is: " + reportTitle);
//            HelperMethods.switchWindow(driver);
//
//            HelperMethods.waitAndSendKeys(corporationNameValue, reportTitle, driver);
//            HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber, driver);
//        }
        driver.get("https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next");
        System.out.println("-------: '" + "https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next" + ":-------");
        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver,getNuansReportNumber); // Nov 12, 2021 - Added highLighterMethod to highlight the object before select
        String reportNumber = getNuansReportNumber.getText();
        logger.warn("Report number is: " + reportNumber);
        logger.warn("Corporation Name is: " + randomCorporationName);
        Thread.sleep(2800);
        HelperMethods.switchWindow(driver);
        HelperMethods.waitAndSendKeys(corporationNameValue, randomCorporationName, driver);
        HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber, driver);

        HelperMethods.fluentWaitAndClick(nuansReportDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        Thread.sleep(4500);
        HelperMethods.waitAndClick(checkNameButton, driver);
        Thread.sleep(1900);
        HelperMethods.staleElementVisible(corporationNameHeading, driver);
        HelperMethods.fluentLongWaitAndCheckVisible(clearNameButton, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);

        return randomCorporationName;
    }

    public String completeCorporationNameForeignCorp(String browser) throws InterruptedException {
        String randomBusinessName = HelperMethods.randomString() + HelperMethods.generateRandomNumber(9999,1111)+ " test inc.";
        logger.warn("Business name is: " + randomBusinessName);
        Reporter.log("Business name is: " + randomBusinessName);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);

        HelperMethods.fluentWaitAndCheckVisible(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.waitAndClick(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameValue, driver);

        HelperMethods.createNewTabAndStayFocused(driver);

        driver.get("https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomBusinessName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next");
        Thread.sleep(1500);
        HelperMethods.createNewTabAndStayFocused(driver);
        Thread.sleep(3500);
        driver.get("https://www-pre.nuans.com/app/scr/corp/nuans/xml/activeReports.xml");
        Thread.sleep(3500);
        driver.getWindowHandle();

        if (browser.equals("chrome")) {
            HelperMethods.highLighterMethod(driver,nuansReportNumber); // Nov 12, 2021 - Added highLighterMethod to highlight the object before select
            String reportNumber = nuansReportNumber.getText();
            logger.warn("Report number is: " + reportNumber);
            String reportTitle = nuansReportTitle.getText();
            logger.warn("Report title is: " + reportTitle);
            HelperMethods.switchWindow(driver);

            HelperMethods.waitAndSendKeys(corporationNameValue, reportTitle, driver);
            HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber, driver);
        } else if (browser.equals("firefox")) {
            String reportNumber = nuansReportNumberFirefox.getText();
            logger.warn("Report number is: " + reportNumber);
            String reportTitle = nuansReportTitleFirefox.getText();
            logger.warn("Report title is: " + reportTitle);
            HelperMethods.switchWindow(driver);

            HelperMethods.waitAndSendKeys(corporationNameValue, reportTitle, driver);
            HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber, driver);
        }

        HelperMethods.fluentWaitAndClick(nuansReportDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.fluentLongWaitAndCheckVisible(clearNameButtonForeign, driver);

//        HelperMethods.staleElementClick(saveAndContinue, driver);

        return randomBusinessName;
    }

    public boolean ontarioBusinessCorporationIsRegistered() throws IOException, InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(getBusinessNameSoleProprietorship());
        HelperMethods.fluentWaitAndClick(Advanced, driver);
        HelperMethods.fluentWaitAndClick(exactMatch, driver);
        Thread.sleep(15000);
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchResults, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
        isCorrect = isCorrect && HelperMethods.compareText(searchStatus, Config.STATUS_ACTIVE, logger);
        isCorrect = isCorrect && HelperMethods.compareText(searchBusinessType, Config.ONTARIO_BUSINESS_CORPORATION_LABEL, logger);
        logger.warn("Business name and number is: " + businessNameValue.getText());
        Reporter.log("Business name and number is: " + businessNameValue.getText());
        File resourcesDirectory = new File("src/main/resources");
        HelperMethods.writeToTextFile(resourcesDirectory +"/ontarioBusinessCorporationIsRegistered.txt",businessNameValue.getText() );
        return isCorrect;
    }

    public boolean ontarioBusinessCorporationIsRegisteredContinues() throws InterruptedException, IOException {
        File resourcesDirectory = new File("src/main/resources");

        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(HelperMethods.readFromTextFile(resourcesDirectory +"/BusinessNameForACorporation.txt"));
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(businessNameValue, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
        isCorrect = isCorrect && HelperMethods.compareText(searchStatus, Config.STATUS_ACTIVE, logger);
        HelperMethods.staleElementClick(businessNameValue, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        HelperMethods.staleElementClick(fileADeclarationFiling, driver);

        HelperMethods.highLighterMethod(driver, corporationName);
        logger.info("Corporation Name is: " + corporationName.getText());
        Reporter.log("Corporation Name is: " + corporationName.getText());

        HelperMethods.highLighterMethod(driver, transactionNumberValue);
        logger.info("Transaction Number is: " + transactionNumberValue.getText());
        Reporter.log("Transaction Number is: " + transactionNumberValue.getText());

        HelperMethods.highLighterMethod(driver, ontarioCorporationOCNNumber);
        logger.info("Ontario Corporation Number (OCN) is: " + ontarioCorporationOCNNumber.getText());
        Reporter.log("Ontario Corporation Number (OCN) is: " + ontarioCorporationOCNNumber.getText());

        HelperMethods.highLighterMethod(driver, getBusinessName);
        logger.info("Proposed Business Name is: " + getBusinessName.getText());
        Reporter.log("Proposed Business Name is: " + getBusinessName.getText());
        Thread.sleep(200);
        return isCorrect;
    }
    public void completeGeneralPartnershipPowerOfAttorneyAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(personAuthorizingOption, driver);
//        HelperMethods.waitAndClick(selectFromPartnersOption, driver);
        //   HelperMethods.selectOptionFromDropdownWithValueOf("Contact first CONTACT LAST", selectFromPartnersOption, driver);
        HelperMethods.selectOptionFromDropdownselectByIndex(1, selectFromPartnersOption, driver);
//        HelperMethods.fluentWaitAndClick(partnerOption, driver);
        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(authorizationHeading, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
//        }
    }
    public void completePowerOfAttorneyAndSave() {
        if (pageTitle.getText().equals(Config.FILE_DECLARATION_OF_EXTRA_PROVINCIAL_LIMITED_LIABILITY_HEADING)) {
            HelperMethods.fluentWaitAndCheckVisible(powerOfAttorneyHeading, driver);
            HelperMethods.staleElementVisible(saveAndContinue, driver);
            HelperMethods.scrollIntoViewForClick(saveAndContinue, driver);
            HelperMethods.staleElementClick(saveAndContinue, driver);
//            HelperMethods.staleElementVisible(authorizationCheckBox, driver);
//            HelperMethods.staleElementClick(authorizationCheckBox, driver);
//            HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
//            HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        } else {
            HelperMethods.fluentWaitAndCheckVisible(powerOfAttorneyHeading, driver);
            HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
            HelperMethods.staleElementClick(saveAndContinue, driver);
        }
    }

    public void completeConsent() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(accuracyChekBox, driver);
        Thread.sleep(3000);
        HelperMethods.waitAndClick(accuracyChekBox, driver);
    }
    public void selectRegistryAsIncorporateOntarioBusinessCorporation() {
        HelperMethods.fluentWaitAndCheckVisible(servicesTab, driver);
        HelperMethods.waitAndClick(servicesTab, driver);
        HelperMethods.waitAndClick(registerServicesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationsSubMenuOption, driver);
        HelperMethods.waitAndClick(corporationsSubMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(incorporateOntarioBusinessCorporationSubMenuOption, driver);
        HelperMethods.waitAndClick(incorporateOntarioBusinessCorporationSubMenuOption, driver);
    }
    public boolean generalPartnershipNameIsUpdated() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(cancellationFiling, driver);
        HelperMethods.staleElementClick(newRegistrationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);  // As per "Huang, Isabelle (MGCS)"- There is a restriction in test Envs- Dev, Stage & UAT, only the emails with ontario.ca domain wil send out. No email in GMail; therefor, email validation is taken off.
        Thread.sleep(2900);
        return isCorrect;
    }
    public boolean verifyOntarioBusinessCorporation_HeaderDisplayedFrameNumber(String FrameNumber) throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(ontarioBusinessCorporationHeading, driver);
        HelperMethods.highLighterMethod(driver,ontarioBusinessCorporationHeading);
        isCorrect = isCorrect && ontarioBusinessCorporationHeading.getText().contains("Ontario Business Corporation");
        isCorrect = isCorrect && ontarioBusinessCorporationHeading.getText().contains(FrameNumber);
        Reporter.log("Header is displayed as: " + ontarioBusinessCorporationHeading.getText());
        Reporter.log("Frame number '" + FrameNumber +"' is in the heading");
        Reporter.log("Header is correctly displayed with no Microfiche Roll Number and Microfiche Frame number in the heading");
        System.out.println("Header is displayed as: " + ontarioBusinessCorporationHeading.getText());
        System.out.println("Header is correctly displayed with no Microfiche Roll Number and Microfiche Frame number in the heading");

//        HelperMethods.staleElementClick(fileADeclarationFiling, driver);
//        Thread.sleep(2000);
//        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
//        Reporter.log("Transaction Number: " + transactionNumberValue.getText() );
//        Reporter.log("Company Name: " + driver.findElement(By.xpath("//div[@class='appAttrLabelBox appCompanyName']/following-sibling::div[1]")).getText() );
//        Reporter.log("Principal place of Business in Ontario: " + driver.findElement(By.cssSelector("html>body>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(5)>div>div>div>div>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)>div>div>div>div>div>div>div>div>div>div>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div>div>div:nth-of-type(2)>div:nth-of-type(2)")).getText() );
//        Reporter.log("Person authorizing registration: " + driver.findElement(By.xpath("(//div[contains(@class,'appGroupSelector registerExtraProvincialLLCName-wizardBox-authorizationTab-authorizationDetailsBox-authorizationDetails-AuthorizationType')]//div)[2]")).getText() );
//        Reporter.log("Full Name: " + driver.findElement(By.cssSelector("html>body>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(5)>div>div>div>div>div>div:nth-of-type(3)>div>div>div:nth-of-type(2)>div>div>div>div>div:nth-of-type(2)>div>div>div>div>div>div>div>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)>div>div>div>div>div>div>div>div>div>div>div>div:nth-of-type(2)")).getText() );
//        Reporter.log("Address for Service: " + driver.findElement(By.cssSelector("html>body>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(5)>div>div>div>div>div>div:nth-of-type(3)>div>div>div:nth-of-type(2)>div>div>div>div>div:nth-of-type(2)>div>div>div>div>div>div>div>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)>div>div>div>div>div>div>div>div>div:nth-of-type(2)>div>div>div>div>div>div>div:nth-of-type(2)")).getText() );
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='Ok']")), driver);
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);  // As per "Huang, Isabelle (MGCS)"- There is a restriction in test Envs- Dev, Stage & UAT, only the emails with ontario.ca domain wil send out. No email in GMail; therefor, email validation is taken off.
        Thread.sleep(2900);
        return isCorrect;
    }
    public boolean extraProvincialLimitedLiabilityCompanyIsUpdated() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(extraPLCN, driver);
        HelperMethods.staleElementClick(fileADeclarationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        Reporter.log("Transaction Number: " + transactionNumberValue.getText() );
        Reporter.log("Company Name: " + driver.findElement(By.xpath("//div[@class='appAttrLabelBox appCompanyName']/following-sibling::div[1]")).getText() );
//        Reporter.log("Principal place of Business in Ontario: " + driver.findElement(By.cssSelector("html>body>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(5)>div>div>div>div>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)>div>div>div>div>div>div>div>div>div>div>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div>div>div:nth-of-type(2)>div:nth-of-type(2)")).getText() );
        Reporter.log("Person authorizing registration: " + driver.findElement(By.xpath("(//div[contains(@class,'appGroupSelector registerExtraProvincialLLCName-wizardBox-authorizationTab-authorizationDetailsBox-authorizationDetails-AuthorizationType')]//div)[2]")).getText() );
//        Reporter.log("Full Name: " + driver.findElement(By.cssSelector("html>body>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(5)>div>div>div>div>div>div:nth-of-type(3)>div>div>div:nth-of-type(2)>div>div>div>div>div:nth-of-type(2)>div>div>div>div>div>div>div>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)>div>div>div>div>div>div>div>div>div>div>div>div:nth-of-type(2)")).getText() );
//        Reporter.log("Address for Service: " + driver.findElement(By.cssSelector("html>body>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(5)>div>div>div>div>div>div:nth-of-type(3)>div>div>div:nth-of-type(2)>div>div>div>div>div:nth-of-type(2)>div>div>div>div>div>div>div>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)>div>div>div>div>div>div>div>div>div:nth-of-type(2)>div>div>div>div>div>div>div:nth-of-type(2)")).getText() );
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='Ok']")), driver);
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);  // As per "Huang, Isabelle (MGCS)"- There is a restriction in test Envs- Dev, Stage & UAT, only the emails with ontario.ca domain wil send out. No email in GMail; therefor, email validation is taken off.
        Thread.sleep(2900);
        return isCorrect;
    }
    public boolean extraProvincialLimitedLiabilityCompanyIsCanceled() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(extraPLCN, driver);
        HelperMethods.staleElementClick(fileADeclarationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        Reporter.log("Transaction Number: " + transactionNumberValue.getText() );
        Reporter.log("Particulars of Cancellation of an Extra-Provincial Limited Liability Company Name: " + bCAArticlesOfIncorporation.getText() );
        Reporter.log("Transaction Number: " + driver.findElement(By.xpath("//div[@class='appFilingValue appAttrValue']")).getText() );
        Reporter.log("Filing Date: " + driver.findElement(By.xpath("(//div[@class='appFilingValue appAttrValue'])[2]")).getText() );
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='Ok']")), driver);
        Thread.sleep(2900);
        return isCorrect;
    }
    public boolean amendmentBusinessNameRegistrationCorporationIsUpdated() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(amendmentBusinessNameRegistrationCorporation, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(amendmentBusinessNameRegistrationCorporation1, driver);
        HelperMethods.staleElementClick(amendmentBusinessNameRegistrationCorporation, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);  // As per "Huang, Isabelle (MGCS)"- There is a restriction in test Envs- Dev, Stage & UAT, only the emails with ontario.ca domain wil send out. No email in GMail; therefor, email validation is taken off.
        Thread.sleep(2900);
        return isCorrect;
    }

    public boolean AmendRegistrationOfABusinessNameForALimitedPartnership() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        HelperMethods.staleElementClick(amendmentBusinessNameRegistrationCorporation2, driver);
        Thread.sleep(2000);
        HelperMethods.highLighterMethod(driver,transactionNumberValue);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        Thread.sleep(500);
        return isCorrect;
    }

    public boolean AmendARegistrationOfAFirmNameForAGeneralPartnership() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        HelperMethods.staleElementClick(amendmentRegistrationOfAFirmNameForAGeneralPartnership, driver);
        Thread.sleep(2000);
        HelperMethods.highLighterMethod(driver,transactionNumberValue);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        Thread.sleep(500);
        return isCorrect;
    }
    public boolean extraProvincialLimitedLiabilityIsUpdated() throws InterruptedException {
        Thread.sleep(800);
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(makeChangesMenu, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(servicesMenuOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(amendmentExtraProvincialFiling, driver);
        HelperMethods.staleElementClick(newRegistrationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);  // As per "Huang, Isabelle (MGCS)"- There is a restriction in test Envs- Dev, Stage & UAT, only the emails with ontario.ca domain wil send out. No email in GMail; therefor, email validation is taken off.
        Thread.sleep(2900);
        return isCorrect;
    }

    public void ontarioBusinessIncorporationUpdateSubStatusCourtOrderwindingUp() throws InterruptedException {
        Thread.sleep(800);
        HelperMethods.fluentWaitAndCheckVisible(adminMenu, driver);
        HelperMethods.waitAndClick(adminMenu, driver);
        HelperMethods.fluentWaitAndCheckVisible(changeEntityStatusMenuOption, driver);
        HelperMethods.waitAndClick(changeEntityStatusMenuOption, driver);
        HelperMethods.staleElementVisible(firstNameFieldValue, driver);
        HelperMethods.waitAndSendKeys(firstNameFieldValue, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.staleElementVisible(lastNameFieldValue, driver);
        HelperMethods.waitAndSendKeys(lastNameFieldValue, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.uploadFile(driver.findElement(By.xpath("(//*[contains(@class,'appDocumentUploadLink appButton')])[1]")),driver, System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");

        Thread.sleep(1200);
////
//        ((JavascriptExecutor) driver).executeScript(
//                "HTMLInputElement.prototype.click = function() {                     " +
//                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
//                        "};                                                                  ");
////        Thread.sleep(1200);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].style.display='block';", uploadButtonFirst);
//
//// trigger the upload
//        driver.findElement(By.xpath("//button[contains(@class,'appDocumentUpload-')]")).click();
////        HelperMethods.staleElementClick(uploadButtonFirst, driver);
//        System.out.println("user dir: " + System.getProperty("user.dir"));
//        driver.findElement(By.xpath("(//input[@type='file'])[1]"))
//                //.sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
//                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//
//        Thread.sleep(1200);
//////
////        ((JavascriptExecutor) driver).executeScript(
////                "HTMLInputElement.prototype.click = function() {                     " +
////                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
////                        "};                                                                  ");
//////        Thread.sleep(1200);
////        JavascriptExecutor js1 = (JavascriptExecutor) driver;
////        js1.executeScript("arguments[0].style.display='block';", uploadButtonFirst);
////
////// trigger the upload
////        driver.findElement(By.xpath("//button[contains(@class,'appDocumentUpload-')]")).click();
//////        HelperMethods.staleElementClick(uploadButtonFirst, driver);
////        System.out.println("user dir: " + System.getProperty("user.dir"));
////        driver.findElement(By.xpath("(//input[@type='file'])[2]"))
////                //.sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
////                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//
//        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div/div/div[2]/div/button/span[2]")));
        HelperMethods.staleElementClick(driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div/div/div[2]/div/button/span[2]")), driver);
        Thread.sleep(1500);
        HelperMethods.selectOptionFromDropdownWithValueOf("Inactive", entityStatus, driver);
        Thread.sleep(1500);
        HelperMethods.selectOptionFromDropdownWithValueOf("Court Ordered Winding Up", entitySubStatus, driver);
        HelperMethods.waitAndSendKeys(entitySubStatusComments, "Change Entity Status to - 'Court Ordered Winding Up' - " + HelperMethods.getCurrentDateTime(), driver);
        HelperMethods.staleElementClick(selectSubmitButton, driver);
        Thread.sleep(2900);

    }
    public void ontarioBusinessIncorporationUpdateSubStatusCancelledByCB() throws InterruptedException {
        Thread.sleep(800);
        HelperMethods.fluentWaitAndCheckVisible(adminMenu, driver);
        HelperMethods.waitAndClick(adminMenu, driver);
        HelperMethods.fluentWaitAndCheckVisible(changeEntityStatusMenuOption, driver);
        HelperMethods.waitAndClick(changeEntityStatusMenuOption, driver);
        HelperMethods.staleElementVisible(firstNameFieldValue, driver);
        HelperMethods.waitAndSendKeys(firstNameFieldValue, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.staleElementVisible(lastNameFieldValue, driver);
        HelperMethods.waitAndSendKeys(lastNameFieldValue, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);

        Thread.sleep(1200);
//
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
//        Thread.sleep(1200);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", uploadButtonFirst);

// trigger the upload
//        driver.findElement(By.xpath("//button[contains(@class,'appDocumentUpload-')]")).click();
        HelperMethods.highLighterMethod(driver,uploadFileOverlap);
        uploadFileOverlap.click();
//        HelperMethods.staleElementClick(uploadButtonFirst, driver);
        System.out.println("user dir: " + System.getProperty("user.dir"));
        driver.findElement(By.xpath("(//input[@type='file'])[1]"))
                //.sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");

        Thread.sleep(1200);
////
//        ((JavascriptExecutor) driver).executeScript(
//                "HTMLInputElement.prototype.click = function() {                     " +
//                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
//                        "};                                                                  ");
////        Thread.sleep(1200);
//        JavascriptExecutor js1 = (JavascriptExecutor) driver;
//        js1.executeScript("arguments[0].style.display='block';", uploadButtonFirst);
//
//// trigger the upload
//        driver.findElement(By.xpath("//button[contains(@class,'appDocumentUpload-')]")).click();
////        HelperMethods.staleElementClick(uploadButtonFirst, driver);
//        System.out.println("user dir: " + System.getProperty("user.dir"));
//        driver.findElement(By.xpath("(//input[@type='file'])[2]"))
//                //.sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
//                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");

        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div/div/div[2]/div/button/span[2]")));
        HelperMethods.staleElementClick(driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div/div/div[2]/div/button/span[2]")), driver);
        Thread.sleep(1500);
        HelperMethods.selectOptionFromDropdownWithValueOf("Inactive", entityStatus, driver);
        Thread.sleep(1500);
        HelperMethods.selectOptionFromDropdownWithValueOf("Cancelled by CB", entitySubStatus, driver);
        HelperMethods.waitAndSendKeys(entitySubStatusComments, "Change Entity Status to - 'Cancelled by CB' - " + HelperMethods.getCurrentDateTime(), driver);
        HelperMethods.staleElementClick(selectSubmitButton, driver);
        Thread.sleep(2900);

    }

    public boolean verifyMakeChangesMenu(String subMenu) throws InterruptedException {
        Thread.sleep(800);
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(makeChangesMenu, driver);
        HelperMethods.fluentWaitAndClick(makeChangesMenu, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='" + subMenu + "']")), driver);  // "//span[text()='File Annual Return']"
        Thread.sleep(800);
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//span[text()='" + subMenu + "']")));
        Thread.sleep(800);
        Reporter.log("The '" + subMenu +"' option is displayed in drop-down menu under the 'Make Changes' Menu");

        return isCorrect;
    }

    public void selectFileArticlesOfContinuanceUnderBCAFromMakeChangesMenu() throws InterruptedException {
        Thread.sleep(800);
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenu, driver);
        HelperMethods.fluentWaitAndClick(makeChangesMenu, driver);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("(//span[text()='File Articles of Continuance under the Business Corporations Act'])[2]")), driver);  // "//span[text()='File Annual Return']"
        Thread.sleep(800);
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("(//span[text()='File Articles of Continuance under the Business Corporations Act'])[2]")));
        Thread.sleep(800);
        Reporter.log("The 'File Articles of Continuance under the Business Corporations Act' option is displayed in drop-down menu under the 'Make Changes' Menu");
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("(//span[text()='File Articles of Continuance under the Business Corporations Act'])[2]")), driver);
        Thread.sleep(800);
    }
    public boolean generalPartnershipNameIsCancelled() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(cancelFiling, driver);
        HelperMethods.staleElementClick(newRegistrationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger); // As per "Huang, Isabelle (MGCS)"- There is a restriction in test Envs- Dev, Stage & UAT, only the emails with ontario.ca domain wil send out. No email in GMail; therefor, email validation is taken off.
        Thread.sleep(2800);
        return isCorrect;
    }

    public void selectPrimaryActivity() {
        HelperMethods.staleElementVisible(primaryActivityType, driver);
        HelperMethods.fluentWaitAndClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "truck transportation", driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);
    }

    public void selectSaveAndContinue() {
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void cancelAuthorizationAndSubmit() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(confirmMaintenanceCheckBox, driver);
        HelperMethods.fluentWaitAndClick(confirmMaintenanceCheckBox, driver);
        HelperMethods.fluentWaitAndCheckVisible(personAuthorizingOption, driver);
        HelperMethods.waitAndClick(selectFromPartnersDropdownContainer, driver);
        HelperMethods.waitAndSendKeys(partnerTextArea, "Contact", driver);
        HelperMethods.fluentWaitAndCheckVisible(selectFirstPartner, driver);
        HelperMethods.waitAndClick(selectFirstPartner, driver);
        HelperMethods.fluentWaitAndCheckVisible(authorizationHeading, driver);

        HelperMethods.staleElementVisible(decelerationCheckBox, driver);
        HelperMethods.staleElementClick(decelerationCheckBox, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(cancelBusinessNameSubmitButton, driver);
    }

    public boolean fileApplicationForAmendedExtraProvincialLicenceVerification() throws InterruptedException {

        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);

        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(fileADeclarationFiling, driver);
        HelperMethods.staleElementClick(fileADeclarationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("Amended Particulars of CIA - Initial Return is :" + bCAArticlesOfIncorporation.getText());
        Reporter.log("Amended Particulars of BCA - Articles of Incorporation is :" + bCAArticlesOfIncorporation.getText());

        logger.warn("Transaction Number is :" + transactionNumberValue.getText());
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
        Thread.sleep(2900);
        return isCorrect;
    }

    public boolean terminationOfExtraProvincialLicenceIsVerified() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(inactiveTerminationStatusValue, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        HelperMethods.staleElementClick(fileADeclarationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("Particulars of EPCA - Termination of Extra-Provincial Foreign Licence is :" + bCAArticlesOfIncorporation.getText());                         // Added Nov 12, 2021
        Reporter.log("Particulars of EPCA - Termination of Extra-Provincial Foreign Licence is :" + bCAArticlesOfIncorporation.getText());
        Thread.sleep(2900);
        return isCorrect;
    }
    public boolean businessNameRegistrationIsCancelled() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(generalDetailsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(inactiveStatusValue, driver);

        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        HelperMethods.staleElementClick(newRegistrationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);  // Nov 08, 2021 - As per "Huang, Isabelle (MGCS)"- There is a restriction in test Envs- Dev, Stage & UAT, only the emails with ontario.ca domain wil send out. No email in GMail; therefor, email validation is taken off.
        Thread.sleep(2900);
        return isCorrect;
    }

    public boolean ontarioLimitedLiabilityPartnershipIsRegistered() {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(getBusinessNameSoleProprietorship());
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchResults, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
        isCorrect = isCorrect && HelperMethods.compareText(searchStatus, Config.STATUS_ACTIVE, logger);
        isCorrect = isCorrect && HelperMethods.compareText(searchBusinessType, Config.ONTARIO_LIMITED_LIABILITY_PARTNERSHIP_TITLE, logger);
        logger.warn("Business name and number is: " + businessNameValue.getText());
        Reporter.log("Business name and number is: " + businessNameValue.getText());
        return isCorrect;
    }

    public boolean extraProvincialLimitedLiabilityIsRegistered() {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(getBusinessNameSoleProprietorship());
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchResults, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(searchStatus, driver);
        isCorrect = isCorrect && HelperMethods.compareText(searchStatus, Config.STATUS_ACTIVE, logger);
        isCorrect = isCorrect && HelperMethods.compareText(searchBusinessType, Config.EXTRA_PROVINCIAL_LIMITED_LIABILITY_LABEL, logger);
        logger.warn("Business name and number is: " + businessNameValue.getText());
        Reporter.log("Business name and number is: " + businessNameValue.getText());
        return isCorrect;
    }

    public void selectCancelConfirmationCheckBox() {
        HelperMethods.highLighterMethod(driver,cancellationConfirmationCheckBox);
        HelperMethods.staleElementVisible(cancellationConfirmationCheckBox, driver);
        HelperMethods.staleElementClick(cancellationConfirmationCheckBox, driver);
    }
    public void cancellationConfirmationExtraProvincialLimitedLiabilityCompanyName() throws InterruptedException {

        HelperMethods.staleElementVisible(driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label")), driver);
        HelperMethods.highLighterMethod(driver,(driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label"))));
        HelperMethods.staleElementClick((driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label"))), driver);
        HelperMethods.waitAndSendKeys(firstName, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastName, Config.CONTACT_FIRST_NAME_VALUE, driver);


//        HelperMethods.fluentLongWaitAndCheckVisible(enterAddressManually, driver);
//
//        Thread.sleep(15000);
//        HelperMethods.staleElementClick(enterAddressManually, driver);
//        Thread.sleep(4200);
//        HelperMethods.fluentLongWaitAndCheckVisible(streetNumberValue, driver);
//        HelperMethods.waitAndSendKeys(streetNumberValue, "351", driver);
//        HelperMethods.waitAndSendKeys(streetNameValue, Config.STREET_NAME_VALUE, driver);

        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver, addressLookupField);
        HelperMethods.staleElementVisible(addressLookupField, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_DR, driver);
//        HelperMethods.staleElementVisible(driver.findElement(By.xpath("//span[text()='Done']")), driver);
//        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Done']")), driver);
//        HelperMethods.waitAndSendKeys(cityValue, Config.CITY_VALUE, driver);
//        HelperMethods.waitAndClick(provinceDropdownAddDirector, driver);
//        HelperMethods.waitAndSendKeys(jurisdictionSearchArea, Config.PROVINCE_ONTARIO, driver);
//        HelperMethods.waitAndClick(jurisdictionSearchResultCanada, driver);
//
//        HelperMethods.fluentLongWaitAndCheckVisible(postalCodeValue, driver);
//        HelperMethods.waitAndSendKeys(postalCodeValue, Config.POSTAL_CODE_VALUE, driver);

        HelperMethods.fluentWaitAndCheckVisible(compliedWithSubSectionCheckBox, driver);
        Thread.sleep(1200);
        HelperMethods.staleElementClick(compliedWithSubSectionCheckBox, driver);



        HelperMethods.highLighterMethod(driver,selectSubmitButton);
        HelperMethods.staleElementVisible(selectSubmitButton, driver);
        HelperMethods.staleElementClick(selectSubmitButton, driver);
    }
    public void selectCancelBusinessSubmitButton() throws InterruptedException {
        HelperMethods.staleElementVisible(cancelBusinessSubmitButton, driver);
        Thread.sleep(2000);
        HelperMethods.staleElementClick(cancelBusinessSubmitButton, driver);
    }

    public void selectSubmitButton() {
        HelperMethods.staleElementVisible(selectSubmitButton, driver);
        HelperMethods.staleElementClick(selectSubmitButton, driver);
    }
    public void contactName() throws InterruptedException {
        HelperMethods.staleElementVisible(firstNameFieldValue, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        HelperMethods.staleElementVisible(findAddressTextArea, driver);
        HelperMethods.staleElementVisible(lastNameFieldValue, driver);
        HelperMethods.staleElementVisible(editButton, driver);
        HelperMethods.staleElementVisible(removeButton, driver);
        Thread.sleep(500);
        HelperMethods.waitAndSendKeys(firstNameFieldValue, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameFieldValue, Config.CONTACT_LAST_NAME_VALUE, driver);
    }

    public void completeAddressAndSubmit() {
        HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
        HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.fluentWaitAndClick(findAddressButton, driver);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.staleElementVisible(submitButtonAmend, driver);
        HelperMethods.staleElementClick(submitButtonAmend, driver);
    }

    public void updateEmail() {
        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        officialEmailValue.clear();
        confirmOfficialEmailValue.clear();
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.UPDATED_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.UPDATED_EMAIL_VALUE, driver);
    }

    public void completeEmailAndSave() {
        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        confirmOfficialEmailValue.clear();
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }
    public void reviewAuthorizationAndSubmit() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Review and Authorization']")), driver);
//        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Review and Authorization']")), driver);
        HelperMethods.fluentWaitAndCheckVisible(amendConfirm, driver);
        Thread.sleep(3000);
        HelperMethods.staleElementClick(amendConfirm, driver);
        Thread.sleep(5000);
        HelperMethods.staleElementClick(selectSubmitButton, driver);
    }
    public void selectAuthorizationAndSubmit() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(authorizationTabLink, driver);
        HelperMethods.staleElementClick(authorizationTabLink, driver);
//        HelperMethods.fluentWaitAndCheckVisible(saveAndContinueAmendRegistration, driver);     // Nov 8, 2021 - added
        Thread.sleep(1000);
        HelperMethods.staleElementClick(saveAndContinue, driver);    // Nov 8, 2021 - added
//        HelperMethods.fluentWaitAndClick(saveAndContinueAmendRegistration, driver); // Nov 8, 2021 - added  "saveAndContinue" button in "Authorization" page
        HelperMethods.fluentWaitAndCheckVisible(declarationCheckBox, driver);
        HelperMethods.staleElementClick(declarationCheckBox, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(amendBusinessSubmitButton, driver);
        HelperMethods.staleElementClick(amendBusinessSubmitButton, driver);
    }
    public void CancellationConfirmationSubmit() throws InterruptedException {
        HelperMethods.highLighterMethod(driver,cancellationConfirmationCheckBox);
        HelperMethods.staleElementVisible(cancellationConfirmationCheckBox, driver);
        HelperMethods.staleElementClick(cancellationConfirmationCheckBox, driver);
        HelperMethods.fluentWaitAndCheckVisible(declarationCheckBox, driver);
        HelperMethods.staleElementClick(declarationCheckBox, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(cancelBusinessRegSubmitButton, driver);
    }

    public void CancellationConfirmationPartnersOptionSubmit() throws InterruptedException {
        HelperMethods.highLighterMethod(driver,cancellationConfirmationCheckBox);
        HelperMethods.staleElementVisible(cancellationConfirmationCheckBox, driver);
        HelperMethods.staleElementClick(cancellationConfirmationCheckBox, driver);
        HelperMethods.fluentWaitAndCheckVisible(declarationCheckBox, driver);
        HelperMethods.staleElementClick(declarationCheckBox, driver);
        Thread.sleep(1000);
        setSelectFromPartnersOption();
        HelperMethods.staleElementClick(cancelBusinessRegSubmitButton, driver);
    }
    public void renewConfirmationSubmit() throws InterruptedException {
        HelperMethods.highLighterMethod(driver,cancellationConfirmationCheckBox);
        HelperMethods.staleElementVisible(cancellationConfirmationCheckBox, driver);
        HelperMethods.staleElementClick(cancellationConfirmationCheckBox, driver);
        HelperMethods.fluentWaitAndCheckVisible(declarationCheckBox, driver);
        HelperMethods.staleElementClick(declarationCheckBox, driver);
        Thread.sleep(2000);
        HelperMethods.highLighterMethod(driver,renewBusinessRegSubmitButton);
        HelperMethods.staleElementClick(renewBusinessRegSubmitButton, driver);
    }
    public void renewConfirmationSubmitOntarioLimitedLiabilityPartnership() throws InterruptedException {
        HelperMethods.highLighterMethod(driver,cancellationConfirmationCheckBox);
        HelperMethods.staleElementVisible(cancellationConfirmationCheckBox, driver);
        HelperMethods.staleElementClick(cancellationConfirmationCheckBox, driver);
        HelperMethods.fluentWaitAndCheckVisible(declarationCheckBox, driver);
        HelperMethods.staleElementClick(declarationCheckBox, driver);
        Thread.sleep(2000);
        HelperMethods.selectOptionFromDropdownselectByIndex(1, selectFromPartnersOption, driver);
     //   HelperMethods.selectOptionFromDropdownWithValueOf("Contact first CONTACT LAST", selectFromPartnersOption, driver);
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver,renewBusinessRegSubmitButton);
        HelperMethods.staleElementClick(renewBusinessRegSubmitButton, driver);
    }
    public void submitVoluntaryWindingUpNotForProfitCorporation_NoticeOfSpecialResolution() throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(nuansReportDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        HelperMethods.fluentWaitAndClick(addALiquidator, driver);
        HelperMethods.fluentWaitAndClick(individualLink, driver);

//        Thread.sleep(5200);
//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndClick(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndSendKeys(firstName, Config.CONTACT_FIRST_NAME_VALUE, driver);
//        HelperMethods.waitAndSendKeys(lastName, Config.CONTACT_FIRST_NAME_VALUE, driver);
//        HelperMethods.waitAndSendKeys(streetNumberValue, "001", driver);
//        HelperMethods.waitAndSendKeys(streetNameValue, Config.STREET_NAME_VALUE, driver);
//        HelperMethods.waitAndSendKeys(cityValue, Config.CITY_VALUE, driver);
//        HelperMethods.waitAndSendKeys(postalCodeValue, Config.POSTAL_CODE_VALUE, driver);
//        HelperMethods.waitAndClick(provinceDropdownAddDirector, driver);
//        HelperMethods.waitAndSendKeys(jurisdictionSearchArea, Config.PROVINCE_ONTARIO, driver);
//        Thread.sleep(1000);
//        HelperMethods.waitAndClick(jurisdictionSearchResultCanada, driver);

        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(firstName, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastName, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.highLighterMethod(driver, addressLookupField);
        HelperMethods.staleElementVisible(addressLookupField, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_DR, driver);

        HelperMethods.fluentWaitAndClick(doneButton, driver);
        Thread.sleep(1900);
        HelperMethods.staleElementClick(amendConfirm, driver);
        Thread.sleep(1900);
        HelperMethods.staleElementClick(selectSubmitButton, driver);
    }
    public boolean soleProprietorshipIsUpdated() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(amendmentSOBusinessName, driver);
        HelperMethods.staleElementClick(businessNameRegistrationForSolePropFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("Business name and number is: " + transactionNumberValue.getText());
        Reporter.log("Business name and number is: " + transactionNumberValue.getText());

//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }
    public boolean  RenewRegistrationOfABusinessNameForAPartnershipIsUpdated() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(renewPartnershipBusinessName, driver);
        HelperMethods.staleElementClick(renewPartnershipBusinessName, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("Business name and number is: " + transactionNumberValue.getText());
        Reporter.log("Business name and number is: " + transactionNumberValue.getText());

//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }

    public boolean  renewalofAnOntarioLimitedPartnershipDeclarationIsUpdated() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(renewalofAnOntarioLimitedPartnershipDeclaration, driver);
        HelperMethods.staleElementClick(renewalofAnOntarioLimitedPartnershipDeclaration, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("Business name and number is: " + transactionNumberValue.getText());
        Reporter.log("Business name and number is: " + transactionNumberValue.getText());

//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }

    public boolean  renewalofRenewARegistration_OfAFirmNameForAGeneralPartnershipIsUpdated() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(renewalofRenewARegistration_OfAFirmNameForAGeneralPartnership, driver);
        HelperMethods.staleElementClick(renewalofRenewARegistration_OfAFirmNameForAGeneralPartnership, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("Business name and number is: " + transactionNumberValue.getText());
        Reporter.log("Business name and number is: " + transactionNumberValue.getText());

//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }

    public boolean  RenewRegistrationOfABusinessNameForOntarioLimitedLiabilityPartnershipIsUpdated() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(renewOntarioLimitedLiabilityPartnershipBusinessName, driver);
        HelperMethods.staleElementClick(renewOntarioLimitedLiabilityPartnershipBusinessName, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("Business name and number is: " + transactionNumberValue.getText());
        Reporter.log("Business name and number is: " + transactionNumberValue.getText());

//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }


    public boolean  RenewRegistrationOfABusinessNameForAExtraProvincialIsUpdated() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(renewalExtraProvincialFiling, driver);
        HelperMethods.staleElementClick(renewalExtraProvincialFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("Business name and number is: " + transactionNumberValue.getText());
        Reporter.log("Business name and number is: " + transactionNumberValue.getText());

//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }

    public void fileArticlesOfFileArrangementOfIncorporation() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfArrangementIncorporationOption, driver);
        HelperMethods.staleElementClick(fileArticlesOfArrangementIncorporationOption, driver);
    }

    public void fileArticlesOfRevivalMakeChanges() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfRevivalOption, driver);
        HelperMethods.staleElementClick(fileArticlesOfRevivalOption, driver);
    }
    public void articlesOfRevivalMakeChanges() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenu, driver);
        HelperMethods.staleElementClick(makeChangesMenu, driver);
        HelperMethods.fluentWaitAndCheckVisible(articlesOfRevivalOption, driver);
        HelperMethods.staleElementClick(articlesOfRevivalOption, driver);
    }

    public void articlesOfArrangementAuthorizationAndSubmit() throws InterruptedException, AWTException {
        HelperMethods.fluentWaitAndCheckVisible(reviewNo, driver);
        HelperMethods.staleElementClick(reviewNo, driver);
        HelperMethods.fluentWaitAndCheckVisible(warnningOk , driver);
        HelperMethods.staleElementClick(warnningOk , driver);
        HelperMethods.fluentWaitAndCheckVisible(summaryOfChanges, driver);
        HelperMethods.waitAndSendKeys(summaryOfChanges, "Summary of Changes - " + HelperMethods.getCurrentDateTime(), driver);
        HelperMethods.fluentWaitAndClick(nuansReportDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        Thread.sleep(1200);
        HelperMethods.highLighterMethod(driver, planOfArrangementUpload);
        HelperMethods.fluentWaitAndClick(planOfArrangementUpload, driver);
        Thread.sleep(2000);

        // Upload using java.awt.Robot
//        HelperMethods.robotTypeString(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//        Thread.sleep(1200);
//        HelperMethods.robotSendENTER();
//        Thread.sleep(7000);

        // Upload using AutoIT
        try {
            Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Upload.exe");
//            Runtime.getRuntime().exec("wscript " + System.getProperty("user.dir")+ "\\Upload.vbs");
//            System.out.println("'wscript " + System.getProperty("user.dir")+ "\\Upload.vbs' - is executed to upload file");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(15000);
        HelperMethods.highLighterMethod(driver, courtOrderUpload);

        HelperMethods.fluentWaitAndClick(courtOrderUpload, driver);
        Thread.sleep(15000);

        // Upload using java.awt.Robot
//        HelperMethods.robotTypeString(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//        Thread.sleep(2000);
//        HelperMethods.robotSendENTER();
//        Thread.sleep(1200);

        // Upload using AutoIT
        try {
            Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Upload.exe");
//            Runtime.getRuntime().exec("wscript " + System.getProperty("user.dir")+ "\\Upload.vbs");
//            System.out.println("'wscript " + System.getProperty("user.dir")+ "\\Upload.vbs' - is executed to upload file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(15000);

//        WebElement element = driver.findElement(By.cssSelector("form#viewInstanceForm>div:nth-of-type(2)>div>div>div>div:nth-of-type(3)>div:nth-of-type(6)>div>div>div>div>div>div>div>div>div>div>div>div:nth-of-type(4)>div>button"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        // Setting value for "style" attribute to make textbox visible
//        js.executeScript("arguments[0].style.display='block';", element);
//        driver.findElement(By.cssSelector("form#viewInstanceForm>div:nth-of-type(2)>div>div>div>div:nth-of-type(3)>div:nth-of-type(6)>div>div>div>div>div>div>div>div>div>div>div>div:nth-of-type(4)>div>button")).sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//
//
//        driver.findElement(By.xpath("(//div[@class='appBoxChildren appBlockChildren']//button)[2]")).sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//        Thread.sleep(1200);
//        driver.findElement(By.xpath("(//div[@class='appBoxChildren appBlockChildren']//button)[3]")).sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//        Thread.sleep(1200);
//
//        planOfArrangementUpload.sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//        Thread.sleep(1200);
//        courtOrderUpload.sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//        Thread.sleep(1200);
        HelperMethods.staleElementClick(authorizationCheckbox, driver);
        HelperMethods.staleElementClick(selectSubmitButton, driver);

    }
}
