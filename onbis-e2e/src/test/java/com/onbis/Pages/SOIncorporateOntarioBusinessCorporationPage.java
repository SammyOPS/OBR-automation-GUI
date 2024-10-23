package com.onbis.Pages;

import com.onbis.Helper.Config;
import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SOIncorporateOntarioBusinessCorporationPage extends PageObject {
    public SOIncorporateOntarioBusinessCorporationPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(xpath = "//span[contains(text(),'Accept')]")
    @FindBy(xpath = "//button[contains(@class, 'acceptTerms') and normalize-space()='Accept']")


    WebElement acceptButton;
    @FindBy(xpath = "//label[text()='Person with Paper Form']")
    WebElement personWithPaperForm;

    @FindBy(xpath = "//span[text()='File Articles of Arrangement']")
    WebElement fileArticlesOfArrangementIncorporationOption;

    @FindBy(css = "input[id*='-FirstName']")
    WebElement firstNameField;
    @FindBy(css = "input[id*='-LastName']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[contains(@id, '-LastName')]")
    WebElement lastNameFieldOverlap;
    //    @FindBy(css = "input[id*='-Email']")
    @FindBy(xpath = "//h1[text()='Contact Information']/following::input[@placeholder='someone@example.com']")
    WebElement emailField;
    //    @FindBy(css = "input[id*='-ConfirmEmail']")
    @FindBy(xpath = "//h1[text()='Contact Information']/following::span[text()='Confirm Email Address']/following::input")
    WebElement confirmEmailField;
    @FindBy(xpath = "//label[contains(@for, '-UseNumberNameYnY')]")
    WebElement willThisCorporationHaveNumberNameYesButton;
    @FindBy(xpath = "//input[contains(@id, '-AuthorizationTypedirectorofficer')]")
    WebElement directorOrOfficerOption;
    @FindBy(xpath = "//label[contains(@for, '-ExemptFromFilingYnY')]")
    WebElement exemptFromFilingOption;
    @FindBy(xpath = "//label[contains(@for, '-UseNumberNameYnN')]")
    WebElement willThisCorporationHaveNumberNameNoButton;
    @FindBy(xpath = "//label[contains(@for, '-AuthorizationYn')]")
    WebElement authorizationCheckBox;
    @FindBy(xpath = "//label[contains(@for,'-NameTypeen')]")
    WebElement corporationWillHaveEnglishOption;
    @FindBy(xpath = "//div[@class='appAttrLabelBox']/following-sibling::input[1]")
    WebElement nuansReportValue;
    @FindBy(xpath = "//div[@class='appFieldHelp']/following-sibling::input[1]")
    WebElement corporationNameValue;
    @FindBy(xpath = "//div[@class='appAttrLabelBox appCompanyName']/following-sibling::input[1]")
    WebElement corporationNameValueOCN;
    @FindBy(css = "div#folder1>div>span:nth-of-type(2)>span>span:nth-of-type(2)")
    WebElement nuansReportNumber;
    @FindBy(css = "div#folder0>div:nth-of-type(2)>div:nth-of-type(4)>span:nth-of-type(2)")
    WebElement getNuansReportNumber;

    @FindBy(xpath = "/nuans_report_list/nuans_report_item[1]/a/span[3]")
    WebElement nuansReportNumberIE;
    @FindBy(xpath = "/nuans_report_list/nuans_report_item[1]")
    WebElement nuansReportNumberFirefox;
    @FindBy(css = "div#folder1 > div:nth-of-type(2) > div:nth-of-type(1) > span:nth-of-type(2)")
    WebElement nuansReportTitle;
    @FindBy(xpath = "/nuans_report_list/nuans_report_item[1]/report_title")
    WebElement nuansReportTitleIE;
    @FindBy(xpath = "/nuans_report_list/nuans_report_item[1]/report_title")
    WebElement nuansReportTitleFirefox;
    @FindBy(css = "select[id*='-LegalExtensionCode']")
    WebElement legalElementForNumberName;
    @FindBy(xpath = "//label[contains(@for,'-UseNumberNameYnY')]")
    WebElement corporationNumberOption;
    @FindBy(xpath = "//div[@class='appInputContainer']//input[1]")
    WebElement requestedDateForContinuance;


    @FindBy(css = "select[id*='-ActiveAuthorizationList']")
    WebElement selectFromDirectorsOrOfficers;

    @FindBy(xpath = "//*[contains(@title, 'Purposes')]")
    WebElement Purposes;
    @FindBy(xpath = "//*[contains(@title, 'SpecialProvisions')]")
    WebElement SpecialProvisions;

    @FindBy(xpath = "//*[contains(@title, 'ShareClassDesc')]")
    WebElement ShareClassDesc;
    @FindBy(xpath = "//*[contains(@title, 'ShareRights')]")
    WebElement ShareRights;
    @FindBy(xpath = "//*[contains(@title, 'ShareTransferDesc')]")
    WebElement ShareTransferDesc;
    @FindBy(xpath = "//*[contains(@title, 'ShareBusinessDesc')]")
    WebElement ShareBusinessDesc;
    @FindBy(xpath = "//*[contains(@title, 'OtherProvisionDesc')]")
    WebElement OtherProvisionDesc;


    @FindBy(xpath = "//label[text()='Registrar'] | //label[text()='Director/Registrar']")
    WebElement selectRegistrar;
    @FindBy(xpath = "//span[text()='Receipt Date']/following::input")
    WebElement receiptDate;
    @FindBy(xpath = "//label[text()='HH:MM']/following::input")
    WebElement receiptDateTime;


    @FindBy(xpath = "//span[text()='Information on File']")
    WebElement informationOnFile;
    @FindBy(xpath = "//div[contains(@class,'appAttrText continueInAsNotForProfitCorp-asyncContainer-wizardBox-jurisdictionTab-ContinuedInNameBox-PreviousName')]//input[1]")
    WebElement currentCorporationName;
    @FindBy(xpath = "//button[.//span[text()='Upload']]")
    WebElement upload;
    @FindBy(xpath = "(//button[@role='button'])[2]")
    WebElement uploadFile1;
    @FindBy(xpath = "(//button[@role='button'])[3]")
    WebElement uploadFile2;
    @FindBy(xpath = "(//button[@role='button'])[4]")
    WebElement uploadFile3;
    @FindBy(xpath = "(//button[contains(@class, 'appDocumentUploadLink') and @role='button'])[1]")
    WebElement uploadFile;
    //"//button[contains(@class,'appDocumentUpload-')]"
    @FindBy(xpath = "(//button[contains(@class, 'appDocumentUploadLink')])[2]")
    WebElement uploadFileOverlap;

    @FindBy(xpath = "(//button[.//span[text()='Upload']])[3]")
    WebElement uploadFileOverlap1;


    @FindBy(xpath = "//div[contains(@class,'appDocumentsContainer finalPlanOfArrangement-withSecurities-presenterDetailsWrapper-presenterDetails-serviceInstancePresenterForm-presenterInstanceForm-documentsBox-documents')]/following-sibling::button[1]")
    WebElement uploadFileOverlap2;

    @FindBy(xpath = "//input[contains(@class, 'appAttrDate webuiValidateDate hasDatepicker')]")
    WebElement requestedDateForArrangement;


    @FindBy(xpath = "(//*[@class=\"appDocumentUploadLink appButton appButtonSecondary appReceiveFocus appClickReady appKeyReady\"])[2]")
    WebElement uploadFileAMEND_EPCA;
//    @FindBy(xpath = "(//button[contains(@class,'LOCAL_DRAFT_PLAN_OF')])")
    @FindBy(xpath = "(//button[.//span[text()='Upload']])[2]")
    WebElement DRAFT_PLAN_OF_NFPCA;
//    @FindBy(xpath = "(//button[contains(@class,'LOCAL_FINAL_PLAN_OF')])")
    @FindBy(xpath = "(//button[.//span[text()='Upload']])[3]")
    WebElement FINAL_PLAN_OF;


    @FindBy(xpath = "//span[text()='Save and Continue']")
    WebElement informationOnFileSaveAndContinue;

    @FindBy(xpath = "//span[text()='The classes and any maximum number of shares that the corporation is authorized to issue:']/following::textarea")
    WebElement sescriptionOfClassesOfShares;
    @FindBy(xpath = "//div[contains(@class,'appAttrText maintainContinueInAsONBusinessCorp-asyncContainer-wizardBox-shareholdingTab-standardShareholdingBox-shareDetailsRecord-sharesOwnTextBox-shareRightsBox-ShareRights')]//textarea[1]")
    WebElement rightsPrivilegesRestrictionsConditions;
    @FindBy(xpath = "//div[@class='appFieldHelp']/following-sibling::textarea[1]")
    WebElement restrictionsOnShareTransfers;
    @FindBy(xpath = "//div[contains(@class,'appAttrText maintainContinueInAsONBusinessCorp-asyncContainer-wizardBox-shareholdingTab-standardShareholdingBox-shareDetailsRecord-sharesOwnTextBox-shareBusinessBox-ShareBusinessDesc')]//textarea[1]")
    WebElement restrictionsOnBusinessOrPowers;
    @FindBy(xpath = "//div[contains(@class,'appAttrText maintainContinueInAsONBusinessCorp-asyncContainer-wizardBox-shareholdingTab-standardShareholdingBox-shareDetailsRecord-sharesOwnTextBox-otherProvisionBox-OtherProvisionDesc')]//textarea[1]")
    WebElement otherProvisions;




    //    @FindBy(xpath = "//*[@id=\"nodeW1435\"]/button/span[2]/span")
    @FindBy(xpath = "//option[contains(text(),'CORP.')]")
    WebElement legalElementForNumberNameValue;
//    @FindBy(xpath = "//span[@class='appReceiveFocus']//span[1]")
    @FindBy(xpath = "//span[contains(text(),'Save and Continue')]")
    WebElement saveAndContinue;

    @FindBy(xpath = " //label[text()='Yes']")
    WebElement addressPrincipalPlaceOfBusinessYes;
    @FindBy(xpath = " //label[text()='No']")
    WebElement addressPrincipalPlaceOfBusinessNo;


    @FindBy(xpath = "//h2[text()='Authorization']")
    WebElement authorizationHeading;
    @FindBy(xpath = "//label[contains(@for,'-AuthorizationType')]")
    WebElement personAuthorizingOption;
    @FindBy(xpath = "//select[contains(@id,'-AuthorisingPartner')]")
    WebElement selectFromPartnersOption;
    @FindBy(xpath = "//select[contains(@id,'-FilingYear')]")
    WebElement annualReturnYearDropdown;

    @FindBy(xpath = "//span[@role='textbox']//span[1]")
    WebElement DirectorsOrOfficers;
    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement DirectorsOrOfficersTextArea;

    @FindBy(xpath = "//li[contains(@id,'select2')]")  // FIRST NAME LAST NAME
    WebElement selectFirstPartner;
    @FindBy(xpath = "//span[contains(@id,'-ActiveAuthorizationList-container')]")
    WebElement selectFromPartnersDropdownContainer;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    WebElement partnerTextArea;
    @FindBy(xpath = "//span[@role='textbox']")
    WebElement selectFromPartnersDropdown;
    @FindBy(xpath = "//div[@class='appFieldHelp']/following-sibling::input[1]")
    WebElement numberOfPartnersField;
    @FindBy(xpath = "(//li[@role='menuitem']//a)[2]")
    WebElement partnerAsIndividualOption;
    @FindBy(xpath = "//span[text()='Add a Partner']/following-sibling::span")
    WebElement addPartnerDropdown;
    @FindBy(xpath = "(//a[@class='delete negativeLink']//span)[2]")
    WebElement removeLink;
    @FindBy(xpath = "(//a[contains(@class,'registerItemSearch-results-page-line-ItemBox-resultLeft-viewMenu')]//span)[2]")
    WebElement searchResultsCorporation;
    @FindBy(xpath = "//button[contains(@class,'appButton registerItemSearch-tabs-criteriaAndButtons-buttonPad-search')]")
    WebElement searchButton;
    @FindBy(id = "QueryString")
    WebElement searchField;
    @FindBy(xpath = "//button[contains(@class,'appButton appWizardButton appWizardNextButton appButtonPrimary')]")
    WebElement saveAndContinueOfficer;
    @FindBy(xpath = "//button[contains(@class,'appButton appRepeaterAdd appIconPlusSign')]")
    WebElement addAnOfficerButton;
    @FindBy(xpath = "//span[text()='Check Name']")
    WebElement checkNameButton;

    @FindBy(xpath = "//div[@class='appFieldHelp']/following-sibling::input[1]")
    WebElement proposedBusinessName;

    @FindBy(xpath = "//label[contains(@for,'-AddressSubTypeUS')]")
    WebElement usAddressOption;
    @FindBy(xpath = "//button[contains(@class,'brRegisterLocalCompany-asyncContainer-wizardBox-detailsTab-details-localNameBox-currentEntityNames-currentEntityName-notNumberNameBox-enName-resetNuansReport')]")
    WebElement clearNameButton;
    @FindBy(xpath = "//div[@class='appFieldHelp']/following-sibling::input")
    WebElement firmNameField;
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
    @FindBy(xpath ="//label[contains(@id, '-OriginalIncorporationDate')]" )
    WebElement OriginalDateOfIncorporationAmalgamation;

    @FindBy(xpath = "//input[@class='webuiValidateDate hasDatepicker']")
    WebElement reregistrationDate;

    @FindBy(xpath = "//span[contains(@id,'-RegionCode-container')]")
    WebElement stateOption;
    //    @FindBy(xpath = "//option[contains(text(),'Arizona')]")
    @FindBy(xpath = "//li[contains(@id,'-AZ')]")
    WebElement stateOptionArizona;
    @FindBy(xpath = "//li[contains(@id,'-Ontario')]")
    WebElement provinceOptionOntario;
    @FindBy(xpath = "//input[@class='webuiValidateDate hasDatepicker']/following-sibling::button[1]")
    WebElement requiredStatementDateIcon;
    @FindBy(xpath = "//button[contains(@class,'ui-datepicker-trigger')]")
    WebElement dateIcon;
    @FindBy(xpath = "//a[contains(@class,'ui-state-default ui-state-highlight')]")
    WebElement jurisdictionTodaysDate;
    @FindBy(xpath = "//a[contains(@class,'ui-state-default ui-state-highlight')]")
    WebElement requestDateForIncorporationTodaysDate;
    @FindBy(xpath = "//label[contains(text(),'Individual')]")
    WebElement individualTypeOption;
    @FindBy(xpath = "//label[text()='Corporation']")
    WebElement CorporationTypeOption;
    @FindBy(xpath = "//span[@class='appLookupLeft left']/following-sibling::input[1]")
    WebElement OntarioCorporationNumber;
    @FindBy(xpath = "//li[@class='ui-menu-item']//a[1]")
    WebElement selectOntarioCorporationNumber;



    @FindAll(@FindBy(xpath = "//*[contains(@class,'appDocumentUploadLink appButton')]"))
    List<WebElement> uploadButton;
    @FindBy(xpath = "//input[@type='file']")
    WebElement uploadButtonInput;
    @FindBy(xpath = "(//input[@type='file'])[2]")
    WebElement uploadButtonContactInfo;
    @FindAll(@FindBy(xpath = "//input[@type='file']"))
    List<WebElement> uploadButtonList;
    @FindBy(xpath = "//button[contains(@id,'_upload_button')]")
    WebElement JurisdictionUploadButton;
//    @FindBy(xpath = "//input[@type='search']")
    @FindBy(xpath = "//div[contains(@class,'appAttributeLookup appAutoComplete')]//input[1]")
    WebElement primaryActivityType;
    @FindBy(xpath = "(//a[contains(@class,'registerGeneralPartnership-wizardBox-gpDetailsTab-businessSectorLookup-primaryBusinessActivityRemote-changeNaicsSelection appNaicsChange')]//span)[2]")
    WebElement changeButton;
//    @FindBy(xpath = "//div[@id='vs1__combobox']")
//    WebElement primaryActivityTypeContainer;

    @FindBy(linkText = "Truck transportation [NAICS 484]")
    private WebElement primaryActivityTypeContainer;

    //h1[@class='appPageTitle']//span[1]
    @FindBy(css = "h1#content>span")
    WebElement articlesOfContinuanceBusinessCorporationActTitle;
    @FindBy(xpath = "//label[text()='Yes']")
    WebElement willThisCorporationHaveANumberNameYes;



//        @FindBy(xpath = "//span[text()='Truck transportation']")
//    @FindBy(xpath = "//ul[@id='vs1__listbox']/li[1]/span[2]")
//    @FindBy(xpath = "//*[@id=\"ui-id-3\"]/li[1]")
//    WebElement primaryActivityTypeTransportation;
    @FindBy(linkText = "Truck transportation [NAICS 484]")
    private WebElement primaryActivityTypeTransportation;


    @FindBy(xpath = "//input[contains(@id, '-Email')]")
    WebElement officialEmailValue;
    @FindBy(xpath = "//input[contains(@id,'-ConfirmEmail')]")
    WebElement confirmOfficialEmailValue;
    @FindBy(xpath = "//h2[contains(text(),'Purposes & Provisions')]")
    WebElement purposesAndProvisionsHeading;
    @FindBy(xpath = "//span[text()='Purposes & Provisions']")
    WebElement purposesAndProvisions;

    @FindBy(xpath = "//label[contains(@for,'-CharityYnY')]")
    WebElement operateAsCharityYesOption;
    @FindBy(xpath = "//textarea[contains(@id,'-Purposes')]")
    WebElement purposeOfCorporationTextArea;
    @FindBy(xpath = "//textarea[contains(@id,'-SpecialProvisions')]")
    WebElement additionalSpecialProvisionsTextArea;
    @FindBy(xpath = "//button[contains(@class,'appButton appWizardButton')]")
    WebElement saveAndContinueButton;
    @FindBy(xpath = "//button[contains(@id,'_upload_button')]")
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
    @FindBy(xpath = "//label[text()='International Address']")
    WebElement internationalAddress;

    @FindBy(xpath = "//label[text()='Yes']")
    WebElement AlsoIncorporatorYes;
    @FindBy(xpath = "//span[text()='Address line 1']/following::input")
    WebElement internationalAddressLine1;
    @FindBy(xpath = "(//span[text()='Address'])[2]/following::input")
    WebElement internationalAddressLine11;

    @FindBy(xpath = "//span[text()='City/Town']/following::input")
    WebElement internationalCityTown;
//    @FindBy(xpath = "//span[text()='Postal code']/following::input")
    @FindBy(xpath = "//span[text()='Postal code']/following::input")
    WebElement internationalPostalCode;
    @FindBy(xpath = "(//span[@role='textbox'])[3]")
    WebElement internationalCountry;
    @FindBy(xpath = "//span[@role='textbox']//span[1]")
    WebElement internationalCountry1;

    @FindBy(xpath = "//span[contains(@class,'select2-selection select2-selection--single')]//span")
    WebElement governingJurisdictionOptionList;
    @FindBy(xpath = "(//span[@class='select2-selection__rendered']//span)[2]")
    WebElement provinceOptionList;
    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement governingJurisdictionSearchArea;
    @FindBy(xpath = "//ul[contains(@id,'-CountryCode-results')]")
    WebElement searchResultsGoverningJurisdiction;

    @FindBy(xpath = "//span[@role='textbox']")
    WebElement internationalCountryBusinessName;

    @FindBy(className = "/html/body/span/span/span[1]/input")
    WebElement internationalCountrySearchbox;

    @FindBy(xpath = "//span[contains(text(),'Add Me as Director')]")
    WebElement addMeAsDirectorButton;
    @FindBy(xpath = "//div[@class='appAttrLabelBox']/following-sibling::input[1]")
    WebElement fixedNumberOfDirectors;
    @FindBy(xpath = "//label[contains(@for,'-ResidentYnY')]")
    WebElement residentCanadaYesOption;
    @FindBy(xpath = "//input[contains(@id,'-addressLookup')]")
    WebElement addressLookupField;
    @FindBy(xpath = "//input[contains(@id,'-NameNumber')]")
    WebElement nameFieldSearch;
//    @FindBy(xpath = "//label[text()='Allocated To Me']")
    @FindBy(xpath = "(//input[@type='checkbox']/following-sibling::label)[2]")

    WebElement allocatedToMe;


    @FindBy(xpath = "(//a[@class='appExpando appExpandoCollapsed']//span)[2]")
    WebElement showFilter;
    @FindBy(xpath = "//div[@class='appExpandoLink']")
    WebElement showFilterOption;
    @FindBy(xpath = "//span[text()='Hide filter']")
    WebElement hideFilterOption;
    @FindBy(xpath = "//button[contains(@id,'-searchButton')]")
    WebElement searchIcon;
    @FindBy(xpath = "//span[contains(text(), 'Do It Now')]")
    WebElement doItNowLink;
    @FindBy(xpath = "//button[contains(@class, 'appButton editTask-taskWrapper-lowerButtonPadBox-buttonPad-approve cm_approve appTaskApprove secondaryButton appNotReadOnly')]")
    WebElement approveFormButton;
    @FindBy(xpath = "//button[contains(@class, 'appButton editTask-taskWrapper-actions-taskActions-taskAction-approve-buttonPad-submit appButtonPrimary primaryButton appPrimaryButton appTaskApproveOk appNotReadOnly appIndex1')]")
//    @FindBy(css = "button[class*=appButton editTask-taskWrapper-actions-taskActions-taskAction-approve-buttonPad-submit appButtonPrimary primaryButton appPrimaryButton appTaskApproveOk appNotReadOnly appIndex1]")
    WebElement approveFormConfirmationButton;
    @FindBy(xpath = "//a[contains(@class,'-addressLookupBox-addressLookupButton')]")
    WebElement findAddressButton;
    @FindBy(xpath = "//input[@name='pcLookupSelection']")
    WebElement pcLookupSelection;
    @FindBy(xpath = "//a[@id='pcLookupOkButton']")
    WebElement pcLookupOkButton;
    @FindBy(xpath =  "//span[text()='Street Number']/following::input")
    WebElement streetNumber;
    @FindBy(xpath =  "//input[@placeholder='123']")
    WebElement streetNumberRegister;


    @FindBy(xpath = "//label[contains(@for,'-principlePlaceOfBusinessExistsYnY')]")
    WebElement placeOfBusinessYes;
    @FindBy(xpath = "//input[@placeholder='Find the address using a postal code...']")
    WebElement findAddressTextArea;
    @FindBy(xpath = "//div[contains(@id,'-RegionCode_labelBox')]")
    WebElement canadaLabel;
    @FindBy(xpath = "//div[contains(@id, 'Title')]")
    WebElement directorTitle;
    @FindBy(xpath = "//label[contains(@for,'-IsAnIncorporatorYnY')]")
    WebElement alsoAnIncorporatorYesOption;
    @FindBy(xpath = "//label[contains(@for,'-DeclarationYn')]")
    WebElement declarationCheckBox;
    @FindBy(xpath = "//span[text()='Resident Canadian?']/following::button")
    WebElement doneButton;
    @FindBy(xpath = "//button[contains(@class,'appButton appButtonSecondary')]")
    WebElement doneButtonNotForProfit;
    @FindBy(xpath = "//label[text()='Use pre-defined text (suggested for private companies)']")
    WebElement sharesAndProvisionsPreDefinedTextOption;
    //    @FindBy(xpath = "//h3[contains(text(),'Other Provisions, if any')]")

    @FindBy(xpath = "//label[text()='Set out my own text (legal advice suggested)']")
    WebElement sharesAndProvisionsSetOutMyOwnTextOption;
    @FindBy(how = How.TAG_NAME, using="p") private WebElement editorNode;
//    WebElement sharesAndProvisionsOtherProvisionsHeading;
    @FindBy(xpath = "//h2[contains(text(),'Shares & Provisions')]")
    WebElement sharesAndProvisionsHeading;
    @FindBy(xpath = "//span[text()='Shares & Provisions']")
    WebElement sharesAndProvisions;


    @FindBy(xpath = "//h2[contains(text(),'Court Order')]")
    WebElement courtOrderHeading;
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
//    @FindBy(xpath = "//label[contains(@for,'-DeclarationYn')]")
//    @FindBy(xpath = "//label[contains(@for,'-StatementYn')]")
    @FindBy(xpath = "//label[contains(@for,'-DeclarationYn')]|//label[contains(@for,'-StatementYn')]")
    WebElement confirmationCheckBox;
    @FindBy(xpath = "//label[contains(@for,'-AuthorizationYn')]")
    WebElement confirmationCheckBoxCertification;
    @FindBy(xpath = "//div[contains(@id,'_labelBox')]")
    WebElement nameLabel;
    @FindBy(xpath = "//span[contains(text(),'Certification')]")
    WebElement certificationStepLink;
    @FindBy(xpath = "//span[contains(text(),'CIA - Initial Return')]")
    WebElement initialReturnLabel;
    @FindBy(xpath = "//span[text()='Business Name Registration for a Sole Proprietorship']")
    WebElement registerBusinessNameForSoleProp;
    @FindBy(xpath = "//span[text()='EPCA - Extra-Provincial Foreign Licence']")
    WebElement registerExtraProvincialForeignLicence;
    @FindBy(xpath = "//span[contains(text(),'Annual Return - " + Config.CURENT_YEAR +"')]")  // "//span[contains(text(),'Annual Return - 2021')]")
    WebElement annualReturnLabel;
    @FindBy(xpath = "//a[contains(@class,'appFilingOpen')]")
    WebElement noticeOfChangeLabel;
    @FindBy(xpath = "(//a[@class='appFilingOpen']//span)[3]")
    WebElement bcaArticleOfIncorporationFiling;
    @FindBy(xpath = "//div[text()='Transaction Number']/following-sibling::div")
    WebElement transactionNumberValue;
    @FindBy(xpath = "//h2[contains(text(),'Filings')]")
    WebElement filingsHeading;
    @FindBy(xpath = "//label[contains(@for,'-StatementYn')]")
    WebElement requiredStatementCheckBox;
    @FindBy(xpath = "//h2[text()='General Details']")
    WebElement generalDetailsHeading;
    @FindBy(xpath = "//span[text()='General Details']")
    WebElement generalDetails;
    @FindBy(xpath = "(//div[@class='appInputContainer']//input)[2]")
    WebElement ceasedActivityInOntarioDate;



    @FindBy(xpath = "//h2[contains(text(),'Required Statements')]")
    WebElement requiredStatementsHeading;
    @FindBy(xpath = "//span[contains(text(),'Application for Extra-Provincial Licence for Forei')]")
    WebElement pageTitle;
    @FindBy(xpath = "//h1[@id='content']")
    WebElement pageTitleArticle;
    @FindBy(xpath = "//div[@class='appPageTitleInner']//span")
    WebElement corpNameAndNumber;



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
    @FindBy(xpath = "//div[text()='Generate PDF']")
    WebElement generatePDF;

    @FindBy(xpath = "//div[contains(@class,'appAttrText continueInAsNotForProfitCorp-asyncContainer-wizardBox-jurisdictionTab-ContinuedInNameBox-PreviousName')]//input[1]")
    WebElement currentCorporationName1;
    @FindBy(xpath = "(//span[@role='textbox'])")
    WebElement selectFromContryDropdown;
    @FindBy(xpath = "//li[contains(@id,'CA')]")
            WebElement selectCountry;
            @FindBy(xpath = "(//span[@role='textbox'])[2]")
            WebElement selectFromProvinceDropdown;
            @FindBy(xpath = "//li[contains(@id,'Alberta')]")
            WebElement selectProvince;

    @FindBy(xpath = "//div[@class='appReviewTitle h2']")
    WebElement reviewHeading;
    @FindBy(xpath = "//div[text()[normalize-space()='Generate PDF']]")
    WebElement generatePDFButton;
    @FindBy(xpath = "//span[contains(text(),'Jurisdiction')]")
    WebElement jurisdictionProgressLink;
    //    @FindBy(xpath = "//div[text()='Review & Authorization']")
    @FindBy(xpath = "//div[contains(text(),'Authorization')]")
    WebElement reviewAndAuthorizationHeading;
//    @FindBy(xpath = "//span[contains(text(), 'Submit')]")
    @FindBy(xpath = "//span[contains(text(), 'Submit') or contains(text(), 'Save and Continue')]")
    WebElement submitButton;
//    @FindBy(css = "form#viewInstanceForm>div:nth-of-type(2)>div>div>div>div:nth-of-type(3)>div:nth-of-type(4)>div>div:nth-of-type(2)>button>span:nth-of-type(2)")
//    @FindBy(xpath = "//*[contains(text(),'Submit')]")

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitButtonReviewAuthorize;
//    @FindBy(xpath = "//button[contains(@class, 'registerExtraProvincialLicenceForForeignCorporationWithShare-asyncContainer-wizardButtonPad-apply')]")
    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitButtonExtraProvincial;
    @FindBy(xpath = "//button[contains(@class, 'appButton -buttonPadWizard-wizardButtonPad-apply')]")
    WebElement submitButtonExtraProvincialInitialReturn;
    @FindBy(xpath = "//button[contains(@class, 'appButton noticeOfChangeCIAA-formButtonsBox-buttonPad-apply')]")
    WebElement submitButtonNoticeOfChange;
    //    @FindBy(xpath = "//button[contains(@class, 'appButton initialReturnCIAA-buttonPadWizard-wizardButtonPad-apply')]")
    @FindBy(xpath = "//div[text()='This application is complete and can be submitted.']/following-sibling::button")
    WebElement submitButtonReviewAuthorizeInitialReturn;
    @FindBy(xpath = "//button[contains(@class,'appButton registerGeneralPartnership-wizardButtonPad-apply')]")
    WebElement submitButtonGP;
//    @FindBy(xpath = "//button[contains(@class, 'appButton assignOntarioCorporationNumber-asyncContainer-buttonPad-apply appButtonPrimary primaryButton appApplyButton appNotReadOnly appIndex3')]")
    @FindBy(xpath = "//label[text()='an English name (example: \"Green Institute Inc.\")']")
                     //input[@type='radio']/following-sibling::label
    WebElement submitButtonOCN;

    @FindBy(xpath = "//*[contains(text(),'Please upload the Constating Document.')]")
    WebElement PleaseUploadTheConstatingDocument;
    @FindBy(xpath = "//span[text()='Submit']")
    WebElement Submit;

    @FindBy(xpath = "//input[@type='checkbox']/following-sibling::label[1]")
    WebElement reviewCertification;

    @FindBy(xpath = "(//button[contains(@class,'ARTICLE_OF_CONTINUANCE_NFPCA')])")
    WebElement articlesOfContinuanceNFPCA;

    @FindBy(xpath = "//button[contains(@class, 'continueInAsONBusinessCorp')]")
    WebElement continueButton;
    //    @FindBy(xpath = "//h1[text()='Contact Information']/following::button")
    //withSecurities-presenterDetailsWrapper-presenterDetails-buttonPad-acceptPresenter
//    @FindBy(xpath = "//button[contains(@class, 'assignOntarioCorporationNumber-withSecurities-presenterDetailsWrapper-presenterDetails-buttonPad-acceptPresenter')]")
    @FindBy(xpath = "//button[contains(@class, 'withSecurities-presenterDetailsWrapper-presenterDetails-buttonPad-acceptPresenter')]")
    WebElement contactInformationContinueButton;
    @FindBy(xpath = "//button[contains(@class, 'brRegisterLocalCompany-withSecurities-presenterDetailsWrapper-presenterDetails-buttonPad-acceptPresenter')]")
    WebElement contactInformationContinueButtonIncorporate;
    //    @FindBy(xpath = "//button[contains(@class, 'initialReturnCIAA-withSecurities-presenterDetailsWrapper-presenterDetails-buttonPad-acceptPresenter')]")
    @FindBy(xpath = "//button[contains(@class, '-withSecurities-presenterDetailsWrapper-presenterDetails-buttonPad-acceptPresenter')]")
    WebElement contactInformationContinueButtonInitialReturn;
    @FindBy(xpath = "//h1[text()='Contact Information']/following::button")
    WebElement continueButtonIncorporateOntarioBusinessCorporation;
//    @FindBy(xpath = "//button[@type='button']")
//    @FindBy(xpath = "//*[contains(text(),'Continue')]")
    @FindBy(xpath = "//span[text()='Continue']")
    WebElement feePaymentContinueButton;
    @FindBy(css = "button#submit_btn")
    WebElement makePayment;
    @FindBy(name = "submit")
    WebElement makePaymentButton;
    @FindBy(xpath = "//*[@id='submit_btn']")   // "//img[@alt='Make Payment']")
    WebElement makePaymentReTry;

    @FindBy(xpath = "//span[text()='Continue']")
    WebElement ContinueButton;


    @FindBy(xpath = "//span[contains(text(), 'Continue')]")
    WebElement Continue;

    @FindBy(css = "div#right_column>div:nth-of-type(2)>div>div:nth-of-type(2)>form>div>input:nth-of-type(2)")
    WebElement makePaymentButton1;


    @FindBy(xpath = "//strong[text()[normalize-space()='The authorization failed.']]" ) // "//*[@alt=\"error\"]")
    WebElement paymentErrorMessage;          // If payment failed "The authorization failed." will display
//    @FindBy(xpath = "//font[text()='Name on card:']/following::input")
@FindBy(css = "input#trnCardOwner")
    WebElement namOnCardField;
    @FindBy(xpath = "//label[text()='Name on card']/following::input")
    WebElement namOnCardFieldNew;
    @FindBy(xpath = "//font[text()='Card Number:']/following::input")
    WebElement cardNumberField;
    @FindBy(css = "input#trnCardNumber")
    WebElement cardNumberField1;
    @FindBy(xpath = "//label[text()='Card number']/following::input")
    WebElement cardNumberFieldNew;

    @FindBy(xpath = "(//label[text()='MM']/following::input)[2]") // Added Nov 04, 2021
    WebElement cardExpirationMM;
    @FindBy(xpath = "//label[text()='YY']/following::input") // Added Nov 04, 2021
    WebElement cardExpirationYY;
    @FindBy(xpath = "//div[@id='cvv-info-holder']/following-sibling::input[1]") // Added Nov 04, 2021
    WebElement cardtrnCardCvd;
    @FindBy(xpath = "//*[@id=\"submitButton\"]") // Added Nov 04, 2021
    WebElement submitPaymentButtonNew;
    @FindBy(xpath = "//span[text()='Ok']") // Added Nov 04, 2021
    WebElement FinalizeTransactionNotificationOk;



    @FindBy(xpath = "//*[@name=\"trnExpYear\"]") // Added Nov 04, 2021
    WebElement cardExpirationYear;



    @FindBy(xpath = "//*[@name=\"trnCardType\"]") // Added Nov 09, 2021
    WebElement cardType;
    @FindBy(xpath = "//font[text()='Card CVD:']/following::input")
    WebElement cardCVDNumberField;

    @FindBy(css = "input#trnCardCvd")
    WebElement cardCVDNumberField1;



    @FindBy(xpath = "(//input[@type='button'])[2]")
    WebElement submitPaymentButton;

    @FindBy(xpath = "//button[text()='Submit Payment']")
    WebElement submitPaymentButton1;

    @FindBy(xpath = "//input[@alt='Cancel']")
    WebElement cancelButton;
    @FindBy(xpath = "//a[contains(@class,'appDocumentRemove')]")
    WebElement contactInformationRemoveButton;
    @FindBy(xpath = "(//button[@role='button'])[2]")
    WebElement uploadButtonFirst;
    @FindBy(xpath = "//button[contains(@class,'appDocumentUploadLink appButton')]")
    WebElement uploadButtonSecond;
    @FindBy(xpath = "//span[text()='123_pdf-file.pdf']")
    WebElement file123Ppdf;

    // Locator for the popup dialog
    @FindBy(css = "div.ui-dialog[role='dialog']")
    WebElement popupDialog;
    @FindBy(xpath = "//h1[contains(text(),'Contact Information')]")
    WebElement contactInformationHeading;
    @FindBy(xpath = "//a[contains(@class, 'basketView-buttonPad-item4-close negativeLink appReadOnly')]")
    WebElement paymentConfirmationContinueButtonCorporation;
    @FindBy(xpath = "//span[text()='Continue']")
    WebElement paymentConfirmationContinueButton;
    @FindBy(xpath = "//span[text()='Finalize Transaction']")
    WebElement finalizeTransactionButton;
    @FindBy(xpath = "//span[text()='Continue'][1]")
    WebElement CCPayContinueButton;



//    @FindBy(xpath = "//div[contains(@id,'-Code2_labelBox')]/following-sibling::div[1]")
    @FindBy(xpath ="" +
            "")
    WebElement code2Value;
    @FindBy(xpath = "//span[contains(text(),'Dashboard')]")
    WebElement dashboardMenu;
    @FindBy(xpath = "//h1[contains(@id,'content')]")
    WebElement dashboardHeading;
    @FindBy(xpath = "//span[contains(text(),'Completed')]")
    WebElement completedSubMenu;
    @FindBy(xpath = "//*[(text() = 'Services' or . = 'Services')]")
    WebElement servicesTab;
    @FindBy(xpath = "//th[contains(@class, 'dashboardInternal-contentInternal-contentTabs-myFb-mySubmittedList-ServiceInstances-applicationCode')]")
    WebElement applicationTableHeading;
    @FindBy(xpath = "(//div[@class='appAttrValue' and text()='Completed'])[1]")
    WebElement statusTableHeading;
    @FindBy(xpath = "(//div[@class='appAttrValue'])[1]")
    WebElement descriptionName;
    @FindBy(xpath = "//div[contains(@class, 'appAttrText dashboardInternal-contentInternal-contentTabs-myFb-mySubmittedList-ServiceInstances-PrimaryName')]")
    WebElement statusTableName;
    @FindBy(xpath = "//h2[contains(text(),'Sent For Review')]")
    WebElement sentForReviewTitle;
    @FindBy(xpath = "//div[contains(@id,'Title')]")
    WebElement certificationHeading;
//    @FindBy(xpath = "//a[@id='sentForReviewDialogOkButton']")
    @FindBy(xpath = "//span[contains(text(),'Ok')]")
    WebElement okButton;

    @FindBy(xpath = "//a[@id='sentForReviewDialogOkButton']//span[1]")
//@FindBy(css="a#sentForReviewDialogOkButton>span")
//@FindBy(xpath = "//span[contains(text(),'Ok')]")
    WebElement sentForReviewDialogOkButton;

    @FindBy(xpath ="//a[@id='sentForReviewDialogOkButton']")
    WebElement sentForReviewokButton;
    @FindBy(xpath ="//span[contains(text(),'Save and Continue')]")
    WebElement SaveAndContinueButton;
    @FindBy(xpath = "//h2[text()='Jurisdiction']")
    WebElement jurisdictionHeading;
    @FindBy(xpath = "//label[contains(text(),'No')]")
    WebElement corporationPreviouslyRegisteredInOntarioNoOption;
    @FindBy(xpath = "//span[contains(@id,'-CountryCode-container')]")
    WebElement governmentJurisdictionOption;
    @FindBy(xpath = "//option[contains(text(),'United States')]")
    WebElement governmentJurisdictionOptionUS;
    @FindBy(xpath = "//option[contains(text(),'Bermuda')]")
    WebElement governmentJurisdictionOptionBermuda;
    @FindBy(xpath = "//span[contains(text(),'Review & Authorization')]")
    WebElement reviewAndAuthorizationProgressLink;
    @FindBy(xpath = "//select[contains(@id,'-Method')]")
    WebElement paymentMethodOption;
    @FindBy(xpath = "//select[contains(@id,'-EntitySubTypeCode')]")
    WebElement entityTypeOption;
    @FindBy(xpath = "//select[contains(@id,'-ActiveAuthorizationList')]")
    WebElement selectFromDirectorOrOfficerOption;
    @FindBy(xpath = "//option[contains(@value,'Contact First CONTACT LAST')]")
    WebElement selectFromDirectorOptionAsContactFirstValue;
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
    //li[contains(@id, '-Federal')]
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
    @FindBy(xpath = "//form[@id='frmBankLogin']/input[16]")
    WebElement nextButton;
    @FindBy(xpath = "//span[contains(text(),'Clicking on NEXT > will log you out of online bank')]")
    WebElement clickingOnNextText;
    @FindBy(xpath = "//span[text()='Payment Confirmation']")
    WebElement paymentConfirmationButton;
    @FindBy(xpath = "//span[text()='Remove']")
    WebElement removeDirector;
    @FindBy(xpath = "//div[text()='You must add a director.']")
    WebElement mustAddADirector;


    @FindBy(xpath = "(//span[text()='Yes'])[3]")
    WebElement removeDirectorYes;
    @FindBy(css = "html>body>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>a>span")
    WebElement removeDirectorYesCSS;
// +++++
    @FindBy(xpath = "//span[text()='Make Changes']")
    WebElement makeChangesMenuOption;

    @FindBy(xpath = "//span[text()='File Articles of Dissolution']")
    WebElement fileArticlesOfDissolutionOption;
    @FindBy(xpath = "//span[text()='File Application for Termination of Extra-Provincial Licence']")
    WebElement fileApplicationForTerminationOfExtraProvincialLicenceOption;
    @FindBy(xpath = "//span[text()='Notice of Special Resolution']")
    WebElement noticeOfSpecialResolutionOption;

    @FindBy(xpath = "//span[text()='File Application for Amended Extra-Provincial Licence']")
    WebElement fileApplicationForTerminationOfAmendedExtraProvincialLicenceOption;
// ++++++
    @FindBy(xpath = "(//span[text()='Business Names'])[3]")
    WebElement businessNames;
     @FindBy(xpath = "//span[text()='Register a Business Name']\n")
     WebElement registerABusinessNames;
    @FindBy(xpath = "//span[text()='Continue']")
    WebElement registerABusinessNamesContactInformationContinue;

    //+++++++ File Draft Plan of Arrangement
    @FindBy(xpath = "//span[text()='Draft Plan of Arrangement']")
    WebElement fileArticlesOfArrangement;
    @FindBy(xpath = "//div[contains(@class,'appAttrText draftPlanOfArrangement-asyncContainer-tabBox-planOfArrangementTabs-planOfArrangementTab-planOfArrangementBox-serviceinstance-SummaryOfChanges')]//textarea[1]")
    WebElement SummaryOfChangesTextArea;


//+++++++ File Articles of Amendment
@FindBy(xpath = "//span[text()='File Articles of Amendment']")
WebElement fileArticlesOfAmendment;

    @FindBy(xpath = "//input[@class='webuiValidateDate hasDatepicker']")
    WebElement dateAuthorizingAmendment;

    //+++++++ File Articles of Dissolution
    @FindBy(xpath = "//span[text()='File Articles of Dissolution']")
    WebElement fileArticlesOfDissolution;

    @FindBy(xpath = "(//input[@type='radio']/following-sibling::label)[2]")
    WebElement typeOfVoluntaryDissolution;

    @FindBy(xpath = "//label[@class='appAttrLabel']")
    WebElement  authorizedUnderClause237;

    @FindBy(xpath = "//label[text()='The corporation has not commenced business.']")
    WebElement   hasNotCommencedBusiness;

    @FindBy(xpath = "//label[text()='None of the shares of the corporation has been issued.']")
    WebElement sharesOfcorporation;

    @FindBy(xpath = "//label[text()='The corporation has no debts, obligations or liabilities.']")
    WebElement   corporationHasNoDebts;

    @FindBy(xpath = "//label[text()='No property to distribute.']")
    WebElement  noPropertyTodistribute;

    @FindBy(xpath = "//input[@value='futureDated']/following-sibling::label[1]")
    WebElement requestedDateDissolution;

    @FindBy(xpath = "//label[text()='If it was at any time a registered owner of land in Ontario, that it is no longer a registered owner of land in Ontario.']")
    WebElement registeredOwnerOfLand;

    @FindBy(xpath = "//label[text()='There are no proceedings pending in any court against the corporation.']")
    WebElement noProceedingsPending;

    @FindBy(xpath = "//label[text()='The corporation agrees that this application will be sent to Ministry of Finance (MOF) for consent to the dissolution before a certificate of dissolution may be issued.']")
    WebElement applicationMOF;

    @FindBy(xpath = "//label[text()='All notices and returns required under the Corporations Information Act have been filed.']")
    WebElement  AllNoticesReturnsRequired;

    // fileArticlesOfAuthorizationContinueOutOfBusiness

    @FindBy(xpath = "//label[text()='The corporation is applying to continue under the laws of another Canadian Jurisdiction']")
    WebElement  fileArticlesOfAuthorizationContinueOutOfBusiness;
    @FindBy(xpath = "//label[text()='Another Canadian Jurisdiction']")
    WebElement  anotherCanadianJurisdiction;
    @FindBy(xpath = "//div[@class='appRestricted appRestrictedSelect']//select[1]")
    WebElement  jurisdictionCorporationApplyingToContinue;


    @FindBy(css = "form#viewInstanceForm>div:nth-of-type(2)>div>div>div>div:nth-of-type(3)>div:nth-of-type(6)>div>div>div:nth-of-type(3)>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div>div>div>div:nth-of-type(2)>div>div>div>div>div:nth-of-type(2)>select")
    WebElement  selectJurisdiction;

    @FindBy(xpath = "(//label[@class='appAttrLabel'])[2]")
    WebElement  indicateCorporationConfirms;

    @FindBy(xpath = "(//label[@class='appAttrLabel'])[3]")
    WebElement  notDefaultFilingNotices;

    @FindBy(xpath = "//label[text()='The corporation is offering securities to the public within the meaning of subsection 1(6) of the Business Corporations Act.']")
    WebElement  securitiesToPublic;

    @FindBy(xpath = "//span[text()='Court-ordered Winding Up - Dissolution Order']")
    WebElement  courtOrderedWindingUpDissolutionOrders;

    @FindBy(xpath = "(//div[contains(@class,'appAttrText viewLocalNotForProfitCompany-tabsBox-detailsTab-details-hideAttributesBox-StatusDetailsBox-EntityStatusAuthorized')]//div)[2]")
    WebElement  statusFileArticlesOfDissolution;
    @FindBy(xpath = "(//div[contains(@class,'appAttrText viewExtraProvincialCorporation-tabsBox-detailsTab-details-hideAttributesBox-StatusDetailsBox-EntityStatusAuthorized')]//div)[2]")
    WebElement  statusFileArticlesOfContinuance;


    @FindBy(xpath = "(//a[contains(@class,'viewLocalNotForProfitCompany-tabsBox-businessNamesTab-repeaterCategorizerViewBox-inactiveBusinessNameBox-inactiveBusinessRepeater-entityRoleRecord-EntityLinkBox-viewAssociatedBusinessName appMenu')]//span)[2]")
    WebElement fileArticlesOfDissolutionBusinessName;
    @FindBy(xpath = "(//div[contains(@class,'appAttrText viewLocalNotForProfitCompany-tabsBox-businessNamesTab-repeaterCategorizerViewBox-inactiveBusinessNameBox-inactiveBusinessRepeater-entityRoleRecord-EntityStatusAuthorized')]//div)[2]")
    WebElement   statusFileArticlesOfDissolutionBusinessName;

//    @FindBy(xpath = "(//a[contains(@class,'brViewLocalCompany-tabsBox-businessNamesTab-repeaterCategorizerViewBox-inactiveBusinessNameBox-inactiveBusinessRepeater-entityRoleRecord-EntityLinkBox-viewAssociatedBusinessName appMenu')]//span)[2]")
    @FindBy(xpath = "(//a[contains(@class,'viewExtraProvincialCorporation-tabsBox-businessNamesTab-repeaterCategorizerViewBox-inactiveBusinessNameBox-inactiveBusinessRepeater-entityRoleRecord-EntityLinkBox-viewAssociatedBusinessName appMenu')]//span)[2]")
    WebElement filerAticlesOfContinuanceBusinessName;
    @FindBy(xpath = "(//div[contains(@class,'appAttrText viewExtraProvincialCorporation-tabsBox-businessNamesTab-repeaterCategorizerViewBox-inactiveBusinessNameBox-inactiveBusinessRepeater-entityRoleRecord-EntityStatusAuthorized')]//div)[2]")
    WebElement   statusArticlesOfContinuanceBusinessName;


    public String transactionNumber;

    public void acceptTermsAndConditions() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.getWindowHandle();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        HelperMethods.highLighterMethod(driver,acceptButton);
        HelperMethods.fluentWaitAndCheckVisible(acceptButton, driver);
        HelperMethods.fluentWaitAndClick(acceptButton, driver);
    }

    public void completeContactInformationAndSave() {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);

        HelperMethods.fluentWaitAndClick(contactInformationContinueButton, driver);
    }
    public void completeContactInformationNameEmailAndSave() throws InterruptedException {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        Thread.sleep(1200);
        HelperMethods.highLighterMethod(driver, contactInformationContinueButton);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
    }
    public void completeContactInformationRegisterBusinessNameAndSave() throws InterruptedException {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        Thread.sleep(1200);
        HelperMethods.highLighterMethod(driver, uploadButtonSecond);
//
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
//        Thread.sleep(1200);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", uploadButtonFirst); // uploadButtonSecond

// trigger the upload
        HelperMethods.highLighterMethod(driver,uploadFile);
        uploadFile.click();
//        HelperMethods.highLighterMethod(driver,  driver.findElement(By.xpath("//button[contains(@class,'appDocumentUpload-')]")));
//        driver.findElement(By.xpath("//button[contains(@class,'appDocumentUpload-')]")).click();
//        HelperMethods.staleElementClick(uploadButtonFirst, driver);
        System.out.println("user dir: " + System.getProperty("user.dir"));
        driver.findElement(By.xpath("(//input[@type='file'])[1]"))
                //.sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");


        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver, contactInformationContinueButton);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
    }
    public void completeContactInformationNFPCA_FileDraftPlanOfArrangementAndSave() throws InterruptedException {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        Thread.sleep(1200);
        HelperMethods.highLighterMethod(driver, uploadFileOverlap1);
        uploadFileOverlap1.click();
        // Upload using AutoIT
        try {
            Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Upload.exe");
//            Runtime.getRuntime().exec("wscript " + System.getProperty("user.dir")+ "\\Upload.vbs");
//            System.out.println("'wscript " + System.getProperty("user.dir")+ "\\Upload.vbs' - is executed to upload file");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver, contactInformationContinueButton);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
    }
    public void completeContactInformationarticlesOfContinuanceNFPCAAndSave() throws InterruptedException {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        Thread.sleep(1200);
        HelperMethods.highLighterMethod(driver, articlesOfContinuanceNFPCA);
        articlesOfContinuanceNFPCA.click();
        // Upload using AutoIT
        try {
            Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Upload.exe");
//            Runtime.getRuntime().exec("wscript " + System.getProperty("user.dir")+ "\\Upload.vbs");
//            System.out.println("'wscript " + System.getProperty("user.dir")+ "\\Upload.vbs' - is executed to upload file");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver, contactInformationContinueButton);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
    }
    public void completeContactInformationFinalPlanOfArrangementAndSave() throws InterruptedException {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        Thread.sleep(1200);
        HelperMethods.highLighterMethod(driver, FINAL_PLAN_OF);
        FINAL_PLAN_OF.click();
        // Upload using AutoIT
        try {
            Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Upload.exe");
//            Runtime.getRuntime().exec("wscript " + System.getProperty("user.dir")+ "\\Upload.vbs");
//            System.out.println("'wscript " + System.getProperty("user.dir")+ "\\Upload.vbs' - is executed to upload file");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver, contactInformationContinueButton);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
    }
    public void completeContactInformationfileApplicationForAmendedExtraProvincialLicenceAndSave() throws InterruptedException {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        Thread.sleep(1200);
        HelperMethods.highLighterMethod(driver, uploadFileAMEND_EPCA);
        uploadFileAMEND_EPCA.click();
        // Upload using AutoIT
        try {
            Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Upload.exe");
//            Runtime.getRuntime().exec("wscript " + System.getProperty("user.dir")+ "\\Upload.vbs");
//            System.out.println("'wscript " + System.getProperty("user.dir")+ "\\Upload.vbs' - is executed to upload file");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver, contactInformationContinueButton);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
    }
    public void completeContactInformationInstrumentOfContinuanceAndSave() throws InterruptedException, AWTException {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);

        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver, receiptDate);
        HelperMethods.waitAndSendKeys(receiptDate, HelperMethods.getPreviousDate(1), driver);

        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        Thread.sleep(1200);
        HelperMethods.getLatestWindowFocused(driver);
        HelperMethods.switchWindow(driver);
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("(//button[contains(@class,'appDocumentUploadLink appButton')])[2]")));
//        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("(//button[contains(@class,'appDocumentUploadLink appButton')])[2]")));
//        driver.findElement(By.xpath("(//button[contains(@class,'appDocumentUploadLink appButton')])[2]")).sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1200);

        HelperMethods.waitAndClick( driver.findElement(By.xpath("(//button[contains(@class,'appDocumentUploadLink appButton')])[2]")), driver);
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
////
//        ((JavascriptExecutor) driver).executeScript(
//                "HTMLInputElement.prototype.click = function() {                     " +
//                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
//                        "};                                                                  ");
////        Thread.sleep(1200);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].style.display='block';", uploadButtonFirst); // uploadButtonSecond
//
//// trigger the upload
//        HelperMethods.highLighterMethod(driver,  driver.findElement(By.xpath("//button[contains(@class,'appDocumentUpload-')]")));
//        driver.findElement(By.xpath("//button[contains(@class,'appDocumentUpload-')]")).click();
////        HelperMethods.staleElementClick(uploadButtonFirst, driver);
//        System.out.println("user dir: " + System.getProperty("user.dir"));
//        driver.findElement(By.xpath("(//input[@type='file'])[1]"))
//                //.sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
//                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");


        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver, contactInformationContinueButton);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
    }

    public void inCompleteContactInformationAndSaveOCN() throws InterruptedException {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);

        // +++++++
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Last Name must be entered.']")),"Last Name","Last Name must be entered.");
        Reporter.log("-------: Last Name was not entered - error message displayed as '" + driver.findElement(By.xpath("//div[text()='Last Name must be entered.']")).getText() + " :-------");
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Email Address must be entered.']")),"Email Address","Last Name must be entered.");
        Reporter.log("-------: Email Address was not entered - error message displayed as '" + driver.findElement(By.xpath("//div[text()='Email Address must be entered.']")).getText() + " :-------");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Confirm Email Address must be entered.']")),"Confirm Email Address","Last Name must be entered.");
        Reporter.log("-------: Confirm Email Address was not entered - error message displayed as '" + driver.findElement(By.xpath("//div[text()='Confirm Email Address must be entered.']")).getText() + " :-------");
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.fluentWaitAndCheckVisible(confirmEmailField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);

        HelperMethods.fluentWaitAndClick(contactInformationContinueButton, driver);
//        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='You must upload the filing document']")),"Upload the filing document","You must upload the filing document");
// +++++++++


//        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
//        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
//        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
//        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
//        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        Thread.sleep(1200);
//        HelperMethods.uploadFileAutoIT(upload, driver);
        HelperMethods.uploadFile(upload,driver, System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf" );
//        upload.click();
        // Upload the file using the file input element

// trigger the upload
//        driver.findElement(By.xpath("//button[contains(@class,'appDocumentUpload-')]")).click();
//        HelperMethods.staleElementClick(uploadButtonFirst, driver);
//        System.out.println("user dir: " + System.getProperty("user.dir"));
////        driver.findElement(By.xpath("(//input[@type='file'])[2]"))
//                //.sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
//        upload.sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");


        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        Thread.sleep(1500);
//        HelperMethods.highLighterMethod(driver, contactInformationContinueButton);
//        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
//        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
    }
    public void completeContactInformationRegisterExtraProvincialLimitedLiabilityCompanyAndSave() throws InterruptedException {
        HelperMethods.fluentLongWaitAndClick(personWithPaperForm, driver);
        Thread.sleep(1000);
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.highLighterMethod(driver, firstNameField);
        HelperMethods.highLighterMethod(driver, lastNameField);
        HelperMethods.highLighterMethod(driver, emailField);
        HelperMethods.highLighterMethod(driver, confirmEmailField);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//input[@autocomplete='given-name']")), Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//input[@autocomplete='family-name']")), Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);;
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        HelperMethods.highLighterMethod(driver, upload);
        HelperMethods.uploadFile(upload,driver,System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver, contactInformationContinueButton);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
    }
    public void completeContactInformationExtraProvincialLimitedLiabilityCompanyNameAndSave() throws InterruptedException {
        HelperMethods.fluentLongWaitAndClick(personWithPaperForm, driver);
        Thread.sleep(1000);
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
//        HelperMethods.highLighterMethod(driver, firstNameField);
//        HelperMethods.highLighterMethod(driver, lastNameField);
        HelperMethods.highLighterMethod(driver, emailField);
        HelperMethods.highLighterMethod(driver, confirmEmailField);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("(//span[text()='First Name'])[2]/following::input")), Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("(//span[text()='First Name'])[2]/following::input")), Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("(//span[text()='First Name'])[2]/following::input")), Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("(//span[text()='Last Name'])[2]/following::input")), Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        HelperMethods.highLighterMethod(driver, upload);
        HelperMethods.uploadFile(upload,driver,System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(Continue, driver);
        HelperMethods.fluentWaitAndClick(Continue, driver);

        Thread.sleep(1500);
    }
    public void completeContactInformationAndSaveOCN() throws InterruptedException {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
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
        HelperMethods.highLighterMethod(driver,uploadFileOverlap);
        uploadFileOverlap.click();
//        driver.findElement(By.xpath("(//button[contains(@class, 'appDocumentUploadLink')])[2]")).click(); //  "//button[contains(@class,'appDocumentUpload-')]"
//        HelperMethods.staleElementClick(uploadButtonFirst, driver);
        System.out.println("user dir: " + System.getProperty("user.dir"));
        driver.findElement(By.xpath("(//input[@type='file'])[2]"))
                //.sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");


        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver, contactInformationContinueButton);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
    }
    public void completeContactInformationRegistrarSave() throws InterruptedException, AWTException {
        Thread.sleep(1500);
        HelperMethods.fluentLongerWaitAndCheckVisible(selectRegistrar, driver);
        HelperMethods.highLighterMethod(driver, selectRegistrar);
        HelperMethods.waitAndClick(selectRegistrar, driver);
        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver, receiptDate);
        HelperMethods.waitAndSendKeys(receiptDate, HelperMethods.getPreviousDate(0), driver);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime lt = LocalTime.now();
//        System.out.println(LocalTime.now());
//        System.out.println(df.format(lt.minusSeconds(61)));
        HelperMethods.waitAndSendKeys(receiptDateTime, df.format(lt.minusSeconds(61)), driver);

        Reporter.log("Receipt Date was inserted as: " + HelperMethods.getPreviousDate(0) +"; backdating  Time was: '"+ df.format(lt.minusSeconds(61)) + "' , but Current system Time was: '" + lt +'"');
        System.out.println("Receipt Date was inserted as: " + HelperMethods.getPreviousDate(0) +"; Time: '"+ df.format(lt.minusSeconds(61)) + "'  , but Current Time was: '" + lt +'"');
        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver, contactInformationContinueButton);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
    }
    public void completeInformatioOnFileJurisdictionNonEditableSave() throws InterruptedException, AWTException {
        HelperMethods.fluentLongerWaitAndCheckVisible(informationOnFile, driver);
        HelperMethods.highLighterMethod(driver, informationOnFile);
//        HelperMethods.waitAndClick(informationOOnFile, driver);
        if (HelperMethods.isElementDisplayed(currentCorporationName,driver))
        {
            Reporter.log("The entity name " + currentCorporationName.getText() + " is be read only and not editable");
        }
        //div[@class='appAttrValue'])[2]
        Thread.sleep(1200);
// ++++++++

        WebElement element = driver.findElement(By.xpath("(//input[@type='file'])[3]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Setting value for "style" attribute to make textbox visible
        js.executeScript("arguments[0].style.display='block';", element);
        driver.findElement(By.xpath("(//input[@type='file'])[3]")).sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file1.pdf");
//        driver.findElement(By.xpath("(//input[@type='file'])[3]")).sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");

        Thread.sleep(3200);
        WebElement element1 = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // Setting value for "style" attribute to make textbox visible
        js1.executeScript("arguments[0].style.display='block';", element1);
//        driver.findElement(By.xpath("(//input[@type='file'])[3]")).sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\ABC.pdf");
        driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file1.pdf");

        Thread.sleep(3200);

        WebElement element2 = driver.findElement(By.xpath("(//input[@type='file'])[2]"));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        // Setting value for "style" attribute to make textbox visible
        js2.executeScript("arguments[0].style.display='block';", element2);
//        driver.findElement(By.xpath("(//input[@type='file'])[3]")).sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\ABC.pdf");
        driver.findElement(By.xpath("(//input[@type='file'])[2]")).sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file1.pdf");

//
//        Thread.sleep(5000);
//        HelperMethods.highLighterMethod(driver, uploadFile3);
//        Thread.sleep(2000);
//        uploadFile3.sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
////        uploadFile3.sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//        HelperMethods.waitAndClick(uploadFile3, driver);
//        Thread.sleep(7000);
//        HelperMethods.robotSendENTER();
//        Thread.sleep(7000);
////        uploadFile1.sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//        HelperMethods.waitAndClick(uploadFile1, driver);
//        Thread.sleep(7000);
//        HelperMethods.robotTypeString(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//        Thread.sleep(7000);
//        HelperMethods.robotSendENTER();
//        Thread.sleep(7000);
//        HelperMethods.waitAndClick(uploadFile2, driver);
//        Thread.sleep(7000);
//        HelperMethods.robotTypeString(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//        Thread.sleep(7000);
//        HelperMethods.robotSendENTER();
////        Thread.sleep(7000);
////        HelperMethods.highLighterMethod(driver, uploadFile3);
//////        uploadFile3.sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
////        HelperMethods.waitAndClick(uploadFile3, driver);
////        Thread.sleep(2000);
//        HelperMethods.robotTypeString(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//        Thread.sleep(7000);
//        HelperMethods.robotSendENTER();
//        Thread.sleep(1200);
////        uploadFile3.sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
//        Thread.sleep(1200);

        Thread.sleep(3500);
        HelperMethods.highLighterMethod(driver, informationOnFileSaveAndContinue);
        HelperMethods.fluentWaitAndCheckVisible(informationOnFileSaveAndContinue, driver);
        HelperMethods.waitAndClick(informationOnFileSaveAndContinue, driver);
    }
    public void completeInformatioOnFileSave() throws InterruptedException, AWTException {
        HelperMethods.fluentLongerWaitAndCheckVisible(informationOnFile, driver);
        HelperMethods.highLighterMethod(driver, informationOnFile);
//        HelperMethods.waitAndClick(informationOOnFile, driver);

//        Thread.sleep(1200);
// ++++++++
        driver.findElement(By.xpath("(//input[@type='file'])[3]")).sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1200);
        driver.findElement(By.xpath("(//input[@type='file'])[2]")).sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1200);
        driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1200);

        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver, informationOnFileSaveAndContinue);
        HelperMethods.fluentWaitAndCheckVisible(informationOnFileSaveAndContinue, driver);
        HelperMethods.waitAndClick(informationOnFileSaveAndContinue, driver);
    }

    public void completeCorporationNameSave() throws InterruptedException {
        Thread.sleep(1300);
        HelperMethods.fluentWaitAndCheckVisible(corporationNumberOption, driver);
        HelperMethods.staleElementClick(corporationNumberOption, driver);
        HelperMethods.staleElementVisible(legalElementForNumberName, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf("INC.", legalElementForNumberName, driver);
        HelperMethods.highLighterMethod(driver, requestedDateForContinuance);
        HelperMethods.waitAndSendKeys(requestedDateForContinuance, HelperMethods.getPreviousDate(0), driver);
        HelperMethods.fluentWaitAndCheckVisible(informationOnFileSaveAndContinue, driver);
        HelperMethods.fluentWaitAndClick(informationOnFileSaveAndContinue, driver);
    }
    public void saveOnlyAddress() throws InterruptedException {
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
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(informationOnFileSaveAndContinue, driver);
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver, informationOnFileSaveAndContinue);
        Thread.sleep(3000);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[text()='Save and Continue']")), driver);
    }
    public void completeThreeDirectorsSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
        Thread.sleep(2800);
        HelperMethods.fluentWaitAndClick(fixedNumberOption, driver);
        HelperMethods.highLighterMethod(driver,fixedNumberOfDirectorsValue);
        Thread.sleep(7000);
        HelperMethods.waitAndSendKeys(fixedNumberOfDirectorsValue, "3", driver);
        HelperMethods.fluentWaitAndClick(addADirectorButton, driver);

        HelperMethods.staleElementVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(AlsoIncorporatorYes, driver);
        HelperMethods.fluentWaitAndClick(AlsoIncorporatorYes, driver);
        HelperMethods.staleElementVisible(addressLookupField, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        Thread.sleep(3000);
        HelperMethods.staleElementClick(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_DR, driver);

//        HelperMethods.waitAndSendKeys(requestedDateForContinuance, HelperMethods.getPreviousDate(0), driver);
        //div[@class='appInputContainer']//input[1]
        HelperMethods.staleElementVisible(doneButtonNotForProfit, driver);
        HelperMethods.staleElementClick(doneButtonNotForProfit, driver);
        Thread.sleep(1000);
        for (int i = 0; i < 2; i++) {
            HelperMethods.fluentWaitAndCheckVisible(addADirectorButton, driver);
            HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
            HelperMethods.staleElementClick(addADirectorButton, driver);
            HelperMethods.staleElementVisible(firstNameField, driver);
            HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE +i+1, driver);
            HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE +i+1, driver);
            HelperMethods.fluentWaitAndCheckVisible(alsoAnIncorporatorYesOption, driver);
            HelperMethods.fluentWaitAndClick(alsoAnIncorporatorYesOption, driver);
            Thread.sleep(2000);
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
            HelperMethods.staleElementVisible(driver.findElement(By.xpath("//span[text()='Done']")), driver);
            HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Done']")), driver);

//            HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
//            HelperMethods.waitAndSendKeys(firstNameField, Config.SECOND_DIRECTOR_FIRST_NAME +i, driver);
//            HelperMethods.waitAndSendKeys(lastNameField, Config.SECOND_DIRECTOR_NAME +i, driver);
//            HelperMethods.waitAndClick(alsoAnIncorporatorYesOption, driver);
//            HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLinkNotForProfit, driver);
//
//            Thread.sleep(1200);
//            HelperMethods.staleElementClick(enterAddressManuallyLinkNotForProfit, driver);
//            HelperMethods.waitAndSendKeys(streetNumberValue, "1", driver);
//            HelperMethods.waitAndSendKeys(streetNameValue, Config.STREET_NAME_VALUE, driver);
//            HelperMethods.waitAndSendKeys(cityValue, Config.CITY_VALUE, driver);
//            HelperMethods.waitAndClick(provinceDropdownAddDirector, driver);
//            HelperMethods.waitAndSendKeys(jurisdictionSearchArea, Config.PROVINCE_ONTARIO, driver);
//            HelperMethods.waitAndClick(jurisdictionSearchResultCanada, driver);
//
//            HelperMethods.fluentWaitAndCheckVisible(postalCodeValue, driver);
//            HelperMethods.waitAndSendKeys(postalCodeValue, Config.POSTAL_CODE_VALUE, driver);
//            HelperMethods.staleElementClick(doneButtonNotForProfit, driver);
        }
        Thread.sleep(1000);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }
    public void addThreeDirectorsAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
        Thread.sleep(2800);
        HelperMethods.fluentWaitAndClick(fixedNumberOption, driver);
        HelperMethods.highLighterMethod(driver,fixedNumberOfDirectorsValue);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(fixedNumberOfDirectorsValue, "3", driver);
//        HelperMethods.fluentWaitAndClick(addADirectorButton, driver);
//        HelperMethods.staleElementVisible(firstNameField, driver);
//        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
//        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
//        HelperMethods.staleElementVisible(addressLookupField, driver);
//        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
//        HelperMethods.staleElementVisible(findAddressButton, driver);
//        Thread.sleep(1000);
//        HelperMethods.staleElementClick(findAddressButton, driver);
//        Thread.sleep(1000);
//        HelperMethods.waitAndSendKeys(streetNumber, Config.STREET_NUMBER_VALUE_CR, driver);
//        HelperMethods.staleElementVisible(driver.findElement(By.xpath("//span[text()='Done']")), driver);
//        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Done']")), driver);
        HelperMethods.fluentWaitAndCheckVisible(addADirectorButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
        Thread.sleep(1000);
        for (int i = 0; i < 3; i++) {

            HelperMethods.staleElementClick(addADirectorButton, driver);
            HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
            if (HelperMethods.verifyElementGrey(addADirectorButton) !=true) {
                HelperMethods.fluentWaitAndClick(addADirectorButton, driver);
            }
            if (HelperMethods.verifyElementGrey(addADirectorButton) !=true) {
                HelperMethods.fluentWaitAndClick(addADirectorButton, driver);
            }

            HelperMethods.staleElementVisible(firstNameField, driver);
            HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE +i, driver);
            HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE +i, driver);
            HelperMethods.staleElementVisible(addressLookupField, driver);
            HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
            HelperMethods.staleElementVisible(findAddressButton, driver);
            Thread.sleep(1000);
            HelperMethods.staleElementClick(findAddressButton, driver);
            Thread.sleep(1000);
            HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
            HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
            HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_DR, driver);
            HelperMethods.staleElementVisible(driver.findElement(By.xpath("//span[text()='Done']")), driver);
            HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Done']")), driver);
        }
        Thread.sleep(1000);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }
    public void completeDirectorsOnlyAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
        Thread.sleep(2800);
        HelperMethods.fluentWaitAndClick(fixedNumberOption, driver);
        HelperMethods.highLighterMethod(driver,fixedNumberOfDirectorsValue);
        Thread.sleep(7000);
        HelperMethods.waitAndSendKeys(fixedNumberOfDirectorsValue, "1", driver);
        HelperMethods.fluentWaitAndClick(addADirectorButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(residentCanadaYesOption, driver);
        HelperMethods.fluentWaitAndClick(residentCanadaYesOption, driver);
        HelperMethods.staleElementVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.staleElementVisible(addressLookupField, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_DR, driver);

//        HelperMethods.waitAndSendKeys(requestedDateForContinuance, HelperMethods.getPreviousDate(0), driver);
        HelperMethods.staleElementClick(dateIcon, driver);
        HelperMethods.staleElementClick(jurisdictionTodaysDate, driver);
        Thread.sleep(2500);
        Thread.sleep(3000);
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//span[text()='Done']")));
        HelperMethods.staleElementVisible(driver.findElement(By.xpath("//span[text()='Done']")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Done']")), driver);
        Thread.sleep(3000);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }
    public void sharesProvisionsSave() throws InterruptedException {
        Thread.sleep(1000);
//        HelperMethods.fluentWaitAndCheckVisible(sescriptionOfClassesOfShares, driver);
//        HelperMethods.highLighterMethod(driver, sescriptionOfClassesOfShares);
//        HelperMethods.waitAndSendKeys(sescriptionOfClassesOfShares, "Description of Classes of Shares - " + HelperMethods.getCurrentDateTime(), driver);
//        Thread.sleep(1000);
//        HelperMethods.highLighterMethod(driver, rightsPrivilegesRestrictionsConditions);
//        HelperMethods.waitAndSendKeys(rightsPrivilegesRestrictionsConditions, "Rights, Privileges, Restrictions and Conditions - " + HelperMethods.getCurrentDateTime(), driver);
//        HelperMethods.highLighterMethod(driver, restrictionsOnShareTransfers);
//        HelperMethods.waitAndSendKeys(restrictionsOnShareTransfers, "Restrictions on Share Transfers - " + HelperMethods.getCurrentDateTime(), driver);
//        HelperMethods.highLighterMethod(driver, restrictionsOnBusinessOrPowers);
//        HelperMethods.waitAndSendKeys(restrictionsOnBusinessOrPowers, "Restrictions on Business or Powers - " + HelperMethods.getCurrentDateTime(), driver);
//        Reporter.log("Restrictions on Business or Powers was inserted as: " + HelperMethods.getPreviousDate(0));
//        HelperMethods.highLighterMethod(driver, otherProvisions);
//        HelperMethods.waitAndSendKeys(otherProvisions, "Other Provisions - " + HelperMethods.getCurrentDateTime(), driver);
        driver.switchTo().frame(ShareClassDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Classes of Shares: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareRights);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Changes to Rights, Privileges, Restrictions and Conditions: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareTransferDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Changes to Restrictions on Share Transfers: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareBusinessDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Changes to Restrictions on Business or Powers: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(OtherProvisionDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Changes to Other Provisions: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent
//
        HelperMethods.waitAndClick(saveAndContinue, driver);
    }

    public void saveRequiredStatements() throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label")), driver);

        HelperMethods.waitAndClick(driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::label)[2]")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::label)[3]")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("//div[@class='appFormatHint']/following-sibling::input[1]")), driver);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//div[@class='appFormatHint']/following-sibling::input[1]")), HelperMethods.getPreviousDate(7, driver)));
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//div[@class='appFormatHint']/following-sibling::input[1]")), HelperMethods.getPreviousDate(0), driver);
        Reporter.log("Authorization Date was inserted as: " + HelperMethods.getPreviousDate(0));
        HelperMethods.fluentWaitAndCheckVisible(informationOnFileSaveAndContinue, driver);
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver, informationOnFileSaveAndContinue);
        Thread.sleep(3000);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[text()='Save and Continue']")), driver);
    }

    public void reviewAndAuthorization() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(reviewAndAuthorizationProgressLink, driver);
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver,reviewAndAuthorizationProgressLink);
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndCheckVisible(reviewAndAuthorizationProgressLink, driver);
        Thread.sleep(5000);

        HelperMethods.staleElementClick(driver.findElement(By.xpath("//div[@class='appRestricted appRestrictedYesNo']//label[1]")), driver);
        Thread.sleep(5000);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonExtraProvincial, driver);
        HelperMethods.staleElementClick(submitButtonExtraProvincial, driver);

    }

    public void nameGoverningJurisdictionAmendedExtraProvincialLicence() throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("(//span[@class='select2-selection__rendered'])[2]")), driver);
        HelperMethods.waitAndSendKeys(governingJurisdictionSearchArea, Config.USA_STATE_VALUE_CR, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
        Thread.sleep(1000);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);

        Thread.sleep(1200);
        HelperMethods.highLighterMethod(driver, uploadButtonSecond);
        HelperMethods.waitAndClick(uploadButtonSecond, driver);
   //     uploadButtonSecond.click();
        // Upload using AutoIT
        try {
            Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Upload.exe");
//            Runtime.getRuntime().exec("wscript " + System.getProperty("user.dir")+ "\\Upload.vbs");
//            System.out.println("'wscript " + System.getProperty("user.dir")+ "\\Upload.vbs' - is executed to upload file");
            HelperMethods.fluentWaitAndCheckVisible(file123Ppdf, driver);


        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(3000);
        HelperMethods.fluentWaitAndCheckVisible(file123Ppdf, driver);
        HelperMethods.staleElementClick(dateIcon, driver);
        HelperMethods.staleElementClick(jurisdictionTodaysDate, driver);
        Thread.sleep(2500);
        HelperMethods.verifyElementEnabled(generatePDF, driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label[1]")), driver);
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonExtraProvincial, driver);
        HelperMethods.staleElementClick(submitButtonExtraProvincial, driver);

    }
    public void onlyReviewAndAuthorization() throws InterruptedException {

        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonExtraProvincial, driver);
       HelperMethods.staleElementClick(driver.findElement(By.xpath("//div[@class='appRestricted appRestrictedYesNo']//label[1]")), driver);
        Thread.sleep(5000);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonExtraProvincial, driver);
        HelperMethods.staleElementClick(submitButtonExtraProvincial, driver);

    }
    public void completeContactInformationFileArticlesOfContinuanceSave() throws InterruptedException, AWTException {


        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        Thread.sleep(7200);
        // Focus on the popup dialog using JavaScript
//        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", popupDialog);
        HelperMethods.highLighterMethod(driver, uploadFileOverlap2);
        uploadFileOverlap2.click();
        // Upload using AutoIT
        try {
            Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Upload.exe");
//            Runtime.getRuntime().exec("wscript " + System.getProperty("user.dir")+ "\\Upload.vbs");
//            System.out.println("'wscript " + System.getProperty("user.dir")+ "\\Upload.vbs' - is executed to upload file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(3500);
        HelperMethods.highLighterMethod(driver, ContinueButton);
        HelperMethods.fluentWaitAndCheckVisible(ContinueButton, driver);
        Thread.sleep(3500);
        HelperMethods.fluentWaitAndClick(ContinueButton, driver);

//        HelperMethods.waitAndSendKeys(requestedDateForArrangement, HelperMethods.getPreviousDate(1), driver);
//
//        Thread.sleep(7500);
//        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
//        Thread.sleep(3500);
//        HelperMethods.highLighterMethod(driver, contactInformationContinueButton);
//        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
//        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
    }

    public void completeContactInformationGeneralPartnershipAndSave() throws InterruptedException {

        HelperMethods.fluentLongWaitAndClick(personWithPaperForm, driver);
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.highLighterMethod(driver, firstNameField);
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver, lastNameField);
        HelperMethods.highLighterMethod(driver, emailField);
        HelperMethods.highLighterMethod(driver, confirmEmailField);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//input[@autocomplete='given-name']")), Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//input[@autocomplete='family-name']")), Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);;
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        HelperMethods.highLighterMethod(driver, upload);
        HelperMethods.uploadFile(upload,driver,System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        Thread.sleep(1500);
        HelperMethods.highLighterMethod(driver, contactInformationContinueButton);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButton, driver);
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);

    }

    public void completeContactInformationAndSaveIncorporate() throws InterruptedException {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButtonIncorporate, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        Thread.sleep(1200);
//
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
//        Thread.sleep(1200);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", uploadButtonInput);

// trigger the upload
        HelperMethods.highLighterMethod(driver,uploadFile);
        uploadFile.click();
//        driver.findElement(By.xpath("(//button[contains(@class, 'appDocumentUploadLink')])[2]")).click(); // "//button[contains(@class,'appDocumentUpload-')]"

        driver.findElement(By.xpath("(//input[@type='file'])[1]"))
               // .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1200);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButtonIncorporate, driver);
        HelperMethods.waitAndClick(contactInformationContinueButtonIncorporate, driver);
        Thread.sleep(1200);
    }

// ++++++++++++
public void completeContactInformationAndSaveSoleProp() throws InterruptedException {
    HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
    HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
    HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
    HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
    HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
    HelperMethods.fluentWaitAndCheckVisible(ContinueButton, driver);
    HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
    Thread.sleep(1200);
//
    ((JavascriptExecutor) driver).executeScript(
            "HTMLInputElement.prototype.click = function() {                     " +
                    "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                    "};                                                                  ");
//        Thread.sleep(1200);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].style.display='block';", uploadButtonInput);

// trigger the upload
    HelperMethods.highLighterMethod(driver,uploadFile);
    uploadFile.click();
//    driver.findElement(By.xpath("//button[contains(@class,'appDocumentUpload-')]")).click();

    driver.findElement(By.xpath("(//input[@type='file'])[1]"))
            // .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
            .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
    Thread.sleep(1200);
    HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
    HelperMethods.fluentWaitAndCheckVisible(ContinueButton, driver);
    HelperMethods.waitAndClick(ContinueButton, driver);
    Thread.sleep(1200);
}
    public void incompleteContactInformationAndSaveSoleProp() throws InterruptedException {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndClick(ContinueButton, driver);
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Last Name must be entered.']")),"Last Name","Last Name must be entered.");
//        Reporter.log("-------: Last Name was not entered - error message displayed as '" + driver.findElement(By.xpath("//div[text()='Last Name must be entered.']")).getText() + " :-------");
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndClick(ContinueButton, driver);
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Email Address must be entered.']")),"Email Address","Last Name must be entered.");
//        Reporter.log("-------: Email Address was not entered - error message displayed as '" + driver.findElement(By.xpath("//div[text()='Email Address must be entered.']")).getText() + " :-------");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Confirm Email Address must be entered.']")),"Confirm Email Address","Last Name must be entered.");
//        Reporter.log("-------: Confirm Email Address was not entered - error message displayed as '" + driver.findElement(By.xpath("//div[text()='Confirm Email Address must be entered.']")).getText() + " :-------");
//        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='You must upload the filing document']")),"Upload the filing document","You must upload the filing document");
//        Reporter.log("-------: Upload the filing document was not entered - error message displayed as '" + driver.findElement(By.xpath("//div[text()='You must upload the filing document']")).getText() + " :-------");


        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(ContinueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        Thread.sleep(1200);
//
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
//        Thread.sleep(1200);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", uploadButtonInput);

// trigger the upload
        HelperMethods.highLighterMethod(driver,uploadFile);
        uploadFile.click();
//        driver.findElement(By.xpath("//button[contains(@class,'appDocumentUpload-')]")).click();

        driver.findElement(By.xpath("(//input[@type='file'])[1]"))
                // .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1200);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(ContinueButton, driver);
        HelperMethods.waitAndClick(ContinueButton, driver);
        Thread.sleep(1200);
    }

//    ++++++++++++

    public void completeContactInformationAndSaveregisterABusinessNames() throws InterruptedException {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerABusinessNamesContactInformationContinue, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        Thread.sleep(1200);
//
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
//        Thread.sleep(1200);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", uploadButtonInput);

// trigger the upload
        HelperMethods.highLighterMethod(driver,uploadFile);
        uploadFile.click();
//        driver.findElement(By.xpath("(//button[contains(@class, 'appDocumentUploadLink') and @role='button'])[1]")).click();  // //button[contains(@class,'appDocumentUpload-')]"

        driver.findElement(By.xpath("(//input[@type='file'])[1]"))
                // .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1200);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerABusinessNamesContactInformationContinue, driver);
        HelperMethods.waitAndClick(registerABusinessNamesContactInformationContinue, driver);
        Thread.sleep(1200);
    }

    public void completeContactInformationAndSaveFileInitialReturn() throws InterruptedException {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButtonInitialReturn, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        Thread.sleep(1200);
//
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
//        Thread.sleep(1200);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", uploadButtonInput);

// trigger the upload
        HelperMethods.highLighterMethod(driver,uploadFile);
        uploadFile.click();
//        driver.findElement(By.xpath("(//button[contains(@class, 'appDocumentUploadLink')])[2]")).click(); // "//button[contains(@class,'appDocumentUpload-')]"
//        HelperMethods.staleElementClick(uploadButtonFirst, driver);

        driver.findElement(By.xpath("(//input[@type='file'])[1]"))
//                .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1600);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButtonInitialReturn, driver);
        HelperMethods.staleElementClick(contactInformationContinueButtonInitialReturn, driver);
        Thread.sleep(1600);
    }

    public void completeContactInformationAndSaveFileInitialReturnExtraProvincial() throws InterruptedException {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButtonInitialReturn, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationHeading, driver);
        Thread.sleep(1200);
//
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
//        Thread.sleep(1200);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", uploadButtonInput);

// trigger the upload
        HelperMethods.highLighterMethod(driver,uploadFile);
        uploadFile.click();
//        driver.findElement(By.xpath("//button[contains(@class,'appDocumentUpload-')]")).click(); // "//button[contains(@class,'appDocumentUpload-')]"
//        HelperMethods.staleElementClick(uploadButtonFirst, driver);

        driver.findElement(By.xpath("(//input[@type='file'])[2]"))
//                .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1600);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationRemoveButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(contactInformationContinueButtonInitialReturn, driver);
        HelperMethods.staleElementClick(contactInformationContinueButtonInitialReturn, driver);
        Thread.sleep(1600);
    }

    public void completeCorporationWithNumberAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(willThisCorporationHaveNumberNameYesButton, driver);
        HelperMethods.waitAndClick(willThisCorporationHaveNumberNameYesButton, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf("CORP.", legalElementForNumberName, driver);

        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateValue, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);

        HelperMethods.fluentWaitAndClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "484", driver);
        HelperMethods.staleElementVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);
//        HelperMethods.selectOptionFromDropdownWithValueOf("Truck Transportation [NAICS 484]", primaryActivityType, driver);

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

        HelperMethods.staleElementVisible(addressLookupField, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
//        HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_DR, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
//        HelperMethods.staleElementVisible(driver.findElement(By.xpath("//span[text()='Done']")), driver);
//        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Done']")), driver);

//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndClick(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndSendKeys(streetNumberValue, "001", driver);
//        HelperMethods.waitAndSendKeys(streetNameValue, Config.STREET_NAME_VALUE, driver);
//        HelperMethods.waitAndSendKeys(cityValue, Config.CITY_VALUE, driver);
//        HelperMethods.waitAndSendKeys(postalCodeValue, Config.POSTAL_CODE_VALUE, driver);
//        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
        HelperMethods.fluentWaitAndClick(fixedNumberOption, driver);
        Thread.sleep(500);
        HelperMethods.highLighterMethod(driver,fixedNumberOfDirectorsValue);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(fixedNumberOfDirectorsValue, "1", driver);
        HelperMethods.fluentWaitAndClick(addADirectorButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(addMeAsDirectorButton, driver);
        HelperMethods.fluentWaitAndClick(addMeAsDirectorButton, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(residentCanadaYesOption, driver);
        HelperMethods.fluentWaitAndClick(residentCanadaYesOption, driver);
        HelperMethods.fluentWaitAndClick(alsoAnIncorporatorYesOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(residentCanadaYesOption, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(residentCanadaYesOption, driver);
//        if (HelperMethods.isElementDisplayed( streetNumberValue, driver))
//        {
//            Thread.sleep(1000);
//            HelperMethods.waitAndSendKeys(streetNumberValue, "1", driver);
//            HelperMethods.waitAndSendKeys(streetNameValue, Config.STREET_NAME_VALUE, driver);
//            HelperMethods.waitAndSendKeys(cityValue, Config.CITY_VALUE, driver);
//            HelperMethods.waitAndClick(provinceDropdownAddDirector, driver);
//            HelperMethods.waitAndSendKeys(jurisdictionSearchArea, Config.PROVINCE_ONTARIO, driver);
//            HelperMethods.waitAndClick(jurisdictionSearchResultCanada, driver);
//            HelperMethods.waitAndSendKeys(postalCodeValue, Config.POSTAL_CODE_VALUE, driver);
//        }
        Thread.sleep(1000);
        HelperMethods.staleElementVisible(addressLookupField, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_DR, driver);
        HelperMethods.staleElementVisible(driver.findElement(By.xpath("//span[text()='Done']")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Done']")), driver);


//        Thread.sleep(2000);
//        if (HelperMethods.isElementDisplayed( streetNumberValue, driver))
//        {
//            Thread.sleep(1000);
//            System.out.println("streetNumberValue is: " +streetNumberValue.getText());
//            if (streetNumberValue.getText().equals(""))
//            {
//                HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
//                Thread.sleep(1000);
//                HelperMethods.waitAndClick(findAddressButton, driver);
//            }
//        }
//        Thread.sleep(3000);
//        HelperMethods.staleElementClick(doneButton, driver);
        Thread.sleep(1600);
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
        HelperMethods.staleElementClick(sharesAndProvisionsPreDefinedTextOption, driver);
//        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsOtherProvisionsHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(incorporatorsHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(generatePDFButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(printedAndSavedConfirmationCheckBox, driver);
        HelperMethods.staleElementClick(printedAndSavedConfirmationCheckBox, driver);

        HelperMethods.fluentWaitAndCheckVisible(reviewAndAuthorizationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(generatePDFButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(submitButton, driver);
        Thread.sleep(4500);
        HelperMethods.staleElementClick(submitButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(paymentMethodOption, driver);
        //HelperMethods.selectOptionFromDropdownWithValueOf(Config.DEBIT_CARD_LABEL, paymentMethodOption, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf(Config.CREDIT_CARD_LABEL, paymentMethodOption, driver);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        Thread.sleep(4500);
        HelperMethods.highLighterMethod(driver, feePaymentContinueButton);
        HelperMethods.fluentWaitAndCheckVisible(feePaymentContinueButton, driver);
        HelperMethods.staleElementClick(feePaymentContinueButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(makePayment, driver);
        HelperMethods.staleElementClick(makePayment, driver);
        Thread.sleep(4000);
//        HelperMethods.staleElementClick(submitMakeAPaymentButton, driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(bankOneButton, driver);
//        HelperMethods.staleElementClick(bankOneButton, driver);
//        Thread.sleep(2500);
//        HelperMethods.fluentWaitAndCheckVisible(loginButton, driver);
//        HelperMethods.fluentLongerWaitAndClick(loginButton, driver);
//        Thread.sleep(2500);
////        HelperMethods.fluentWaitAndCheckVisible(fromAccountOption, driver);
//        HelperMethods.fluentWaitAndCheckVisible(sendNowButton, driver);
//        HelperMethods.fluentLongerWaitAndClick(sendNowButton, driver);
//        Thread.sleep(2500);

// +++++++++++++ Payment GUI is upgraded in OBR on April 12, 2022 +++++++++++++
//        HelperMethods.staleElementVisible(namOnCardField, driver);
//        HelperMethods.staleElementVisible(submitPaymentButton, driver);
//        HelperMethods.waitAndSendKeys(namOnCardField, Config.VISA_PAYMENT_NAME, driver);
//        HelperMethods.waitAndSendKeys(cardNumberField, Config.VISA_PAYMENT_NUMBER, driver);
//        HelperMethods.waitAndSendKeys(cardCVDNumberField, Config.VISA_PAYMENT_CVD_NUMBER, driver);
//        HelperMethods.staleElementClick(submitPaymentButton, driver);

 // +++++++++++++ Payment GUI is upgraded in OBR on April 12, 2022 +++++++++++++
        payByVisaCard();

//        HelperMethods.staleElementVisible(namOnCardFieldNew, driver);
//        HelperMethods.staleElementVisible(submitPaymentButtonNew, driver);
//        HelperMethods.waitAndSendKeys(namOnCardFieldNew, Config.VISA_PAYMENT_NAME, driver);
//        HelperMethods.waitAndSendKeys(cardNumberFieldNew, Config.VISA_PAYMENT_NUMBER, driver);
//        HelperMethods.waitAndSendKeys(cardExpirationMM, Config.VISA_PAYMENT_EXPERATION_MM, driver);
//        HelperMethods.waitAndSendKeys(cardExpirationYY, Config.VISA_PAYMENT_EXPERATION_YY, driver);
//        HelperMethods.waitAndSendKeys(cardtrnCardCvd, Config.VISA_PAYMENT_CVD_NUMBER, driver);
//        HelperMethods.staleElementClick(submitPaymentButtonNew, driver);

        Thread.sleep(2500);
        retryOnPaymentFailure();
//        HelperMethods.fluentWaitAndCheckVisible(finalizeTransactionButton, driver);
//        HelperMethods.fluentWaitAndCheckVisible(nextButton, driver);
//        HelperMethods.fluentLongerWaitAndClick(nextButton, driver);

//        HelperMethods.fluentWaitAndCheckVisible(paymentConfirmationContinueButton, driver);
//        HelperMethods.fluentLongerWaitAndClick(paymentConfirmationContinueButton, driver);

        // May 16, 2022 - button labels have been changed and added new code
//        HelperMethods.fluentWaitAndCheckVisible(finalizeTransactionButton, driver);
//        HelperMethods.fluentLongerWaitAndClick(finalizeTransactionButton, driver);
    }

    public void completeCorporationWithNameAndSave(String browser) throws InterruptedException {
        String randomCorporationName = HelperMethods.randomString() + HelperMethods.generateRandomNumber(9999,1111)+ " test inc.";

        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(willThisCorporationHaveNumberNameNoButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.waitAndClick(willThisCorporationHaveNumberNameNoButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(willThisCorporationHaveNumberNameNoButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.waitAndClick(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameValue, driver);

        HelperMethods.createNewTabAndStayFocused(driver);

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

//        HelperMethods.createNewTabAndStayFocused(driver);
//        Thread.sleep(3500);
//        driver.get("https://www-pre.nuans.com/app/scr/corp/nuans/xml/activeReports.xml");
//        Thread.sleep(3500);
//        driver.getWindowHandle();
//        Thread.sleep(3500);
//        if (browser.equals("chrome")) {
//            HelperMethods.highLighterMethod(driver,nuansReportNumber); // Nov 12, 2021 - Added highLighterMethod to highlight the object before select
//            String reportNumber = nuansReportNumber.getText();
//            logger.warn("Report number is: " + reportNumber);
//            String reportTitle = nuansReportTitle.getText();
//            logger.warn("Report title is: " + reportTitle);
//            Thread.sleep(2800);
//            HelperMethods.switchWindow(driver);
//
//            HelperMethods.waitAndSendKeys(corporationNameValue, reportTitle, driver);
//            HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber, driver);
//        }
//        if (browser.equals("edge")) {
//            HelperMethods.highLighterMethod(driver,nuansReportNumber); // Nov 12, 2021 - Added highLighterMethod to highlight the object before select
//            String reportNumber = nuansReportNumber.getText();
//            logger.warn("Report number is: " + reportNumber);
//            String reportTitle = nuansReportTitle.getText();
//            logger.warn("Report title is: " + reportTitle);
//            Thread.sleep(2800);
//            HelperMethods.switchWindow(driver);
//
//            HelperMethods.waitAndSendKeys(corporationNameValue, reportTitle, driver);
//            HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber, driver);
//        }
//        else if (browser.equals("firefox")) {
//            String reportNumber = nuansReportNumberFirefox.getText();
//            logger.warn("Report number is: " + reportNumber);
//            String reportTitle = nuansReportTitleFirefox.getText();
//            logger.warn("Report title is: " + reportTitle);
//            HelperMethods.switchWindow(driver);
//
//            HelperMethods.waitAndSendKeys(corporationNameValue, reportTitle, driver);
//            HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber, driver);
//        }
        Thread.sleep(5500);
        HelperMethods.fluentWaitAndClick(nuansReportDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
        Thread.sleep(3500);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(clearNameButton, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);

        HelperMethods.fluentLongWaitAndCheckVisible(generalDetailsHeading, driver);
        HelperMethods.fluentLongWaitAndCheckVisible(incorporateOntarioBusinessCorporationBanner, driver);
        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateValue, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);

        HelperMethods.fluentLongWaitAndCheckVisible(generalDetailsHeading, driver);
        HelperMethods.fluentWaitAndClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "484", driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

//        HelperMethods.fluentWaitAndCheckVisible(addressHeading, driver);
//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndClick(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndSendKeys(streetNumberValue, "1", driver);
//        HelperMethods.waitAndSendKeys(streetNameValue, Config.STREET_NAME_VALUE, driver);
//        HelperMethods.waitAndSendKeys(cityValue, Config.CITY_VALUE, driver);
//        HelperMethods.waitAndSendKeys(postalCodeValue, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.staleElementVisible(addressLookupField, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_DR, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
        HelperMethods.fluentWaitAndClick(fixedNumberOption, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(fixedNumberOfDirectorsValue, "1", driver);
        HelperMethods.fluentWaitAndClick(addADirectorButton, driver);

        if (driver.getCurrentUrl().contains("appmybizaccount")) {
            HelperMethods.fluentWaitAndCheckVisible(addMeAsDirectorButton, driver);
            HelperMethods.fluentWaitAndClick(addMeAsDirectorButton, driver);
        } else {
            HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
            HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
            HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
            HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
            HelperMethods.waitAndClick(findAddressButton, driver);
            HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
            HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
//            HelperMethods.waitAndSendKeys(streetNumberValue, "1", driver);
//            HelperMethods.waitAndSendKeys(streetNameValue, Config.STREET_NAME_VALUE, driver);
//            HelperMethods.waitAndSendKeys(cityValue, Config.CITY_VALUE, driver);
//            HelperMethods.waitAndSendKeys(postalCodeValue, Config.POSTAL_CODE_VALUE, driver);
        }
        HelperMethods.fluentWaitAndCheckVisible(residentCanadaYesOption, driver);
        HelperMethods.fluentWaitAndClick(residentCanadaYesOption, driver);
        HelperMethods.fluentWaitAndClick(alsoAnIncorporatorYesOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(residentCanadaYesOption, driver);
//        HelperMethods.fluentLongWaitAndCheckVisible(alsoAnIncorporatorYesOption, driver);

        HelperMethods.fluentWaitAndCheckVisible(incorporateOntarioBusinessCorporationBanner, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(addressLookupField, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementVisible(addressLookupField, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(findAddressButton, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_DR, driver);

        HelperMethods.staleElementClick(doneButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(saveAndContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
        HelperMethods.staleElementClick(sharesAndProvisionsPreDefinedTextOption, driver);
//        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsOtherProvisionsHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(incorporatorsHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(generatePDFButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(printedAndSavedConfirmationCheckBox, driver);
        HelperMethods.staleElementClick(printedAndSavedConfirmationCheckBox, driver);

        HelperMethods.fluentWaitAndCheckVisible(reviewAndAuthorizationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(generatePDFButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(submitButton, driver);
        Thread.sleep(4000);
        HelperMethods.staleElementClick(submitButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(paymentMethodOption, driver);
//        HelperMethods.selectOptionFromDropdownWithValueOf(Config.DEBIT_CARD_LABEL, paymentMethodOption, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf(Config.CREDIT_CARD_LABEL, paymentMethodOption, driver);  // Added Nov 12, 2021
        HelperMethods.
                fluentWaitAndCheckVisible(feePaymentContinueButton, driver);
        Thread.sleep(2500);
        HelperMethods.staleElementClick(feePaymentContinueButton, driver);

//        HelperMethods.fluentWaitAndCheckVisible(paymentMethodInteract, driver);
//        HelperMethods.staleElementClick(paymentMethodInteract, driver);
        HelperMethods.staleElementClick(makePayment, driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(bankOneButton, driver);
//        HelperMethods.staleElementClick(bankOneButton, driver);
//        Thread.sleep(2500);
//        HelperMethods.fluentWaitAndCheckVisible(loginButton, driver);
//        HelperMethods.fluentLongerWaitAndClick(loginButton, driver);
//        Thread.sleep(2500);
////        HelperMethods.fluentWaitAndCheckVisible(fromAccountOption, driver);
//        HelperMethods.fluentWaitAndCheckVisible(sendNowButton, driver);
//        HelperMethods.fluentLongerWaitAndClick(sendNowButton, driver);
// Updating / Removed Payment Method
        payByVisaCard();
//        HelperMethods.staleElementVisible(namOnCardField, driver);
//        HelperMethods.staleElementVisible(submitPaymentButton1, driver);
//        HelperMethods.waitAndSendKeys(namOnCardField, Config.VISA_PAYMENT_NAME, driver);
//        HelperMethods.waitAndSendKeys(cardNumberField1, Config.VISA_PAYMENT_NUMBER, driver);
//        HelperMethods.waitAndSendKeys(cardCVDNumberField1, Config.VISA_PAYMENT_CVD_NUMBER, driver);
//        HelperMethods.staleElementClick(submitPaymentButton1, driver);
        Thread.sleep(2500);
// payment Master card as method - Nov 12, 2021
//        HelperMethods.staleElementVisible(namOnCardField, driver);
//        HelperMethods.staleElementVisible(submitPaymentButton, driver);
//        HelperMethods.waitAndSendKeys(namOnCardField, Config.VISA_PAYMENT_NAME, driver);
//        HelperMethods.selectOptionFromDropdownWithValueOf(Config.CARD_TYPE , cardType, driver);
//        HelperMethods.waitAndSendKeys(cardNumberField, Config.MASTER_PAYMENT_NUMBER, driver);
//        HelperMethods.selectOptionFromDropdownWithValueOf(Config.MASTER_PAYMENT_EXPERATION_YEAR , cardExpirationYear, driver);
//        HelperMethods.waitAndSendKeys(cardCVDNumberField, Config.MASTER_PAYMENT_CVD_NUMBER , driver);
//        HelperMethods.staleElementClick(submitPaymentButton, driver);
//        Thread.sleep(2500);
        retryOnPaymentFailure();  // To be added, if Payment fails
//        Thread.sleep(2500);
//        HelperMethods.fluentWaitAndCheckVisible(clickingOnNextText, driver);
//        HelperMethods.fluentWaitAndCheckVisible(nextButton, driver);
//        HelperMethods.fluentLongerWaitAndClick(nextButton, driver);

//        HelperMethods.fluentWaitAndCheckVisible(paymentConfirmationContinueButton, driver);
//        HelperMethods.fluentLongerWaitAndClick(paymentConfirmationContinueButton, driver);

        // May 16, 2022 - button labels have been changed and added new code
//        HelperMethods.fluentWaitAndCheckVisible(finalizeTransactionButton, driver);
//        HelperMethods.fluentLongerWaitAndClick(finalizeTransactionButton, driver);
    }
// ++++++++++
public void completeRegisterABusinessNameForACorporation() throws InterruptedException, IOException {
    String randomCorporationName = HelperMethods.randomString() + " test";
    HelperMethods.fluentWaitAndCheckVisible(checkNameButton, driver);

    HelperMethods.waitAndSendKeys(proposedBusinessName, randomCorporationName, driver);
    logger.warn("Corporation Name is: " + randomCorporationName);
    HelperMethods.staleElementVisible(checkNameButton, driver);
    HelperMethods.waitAndClick(checkNameButton, driver);

    HelperMethods.fluentWaitAndCheckVisible(primaryActivityType, driver);
    HelperMethods.staleElementClick(primaryActivityType, driver);
    HelperMethods.waitAndSendKeys(primaryActivityType, "Truck transportation", driver);
    Thread.sleep(500);
    HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
    HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);
    HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

    // Address  printedAndSavedConfirmationCheckBox
    HelperMethods.fluentWaitAndClick(addressPrincipalPlaceOfBusinessYes, driver);
    Thread.sleep(5000);
    HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
//    HelperMethods.highLighterMethod(driver, selectFromDirectorsOrOfficers);
////    HelperMethods.staleElementVisible(selectFromDirectorsOrOfficers, driver);
//    HelperMethods.selectOptionFromDropdownselectByIndex(0, selectFromDirectorsOrOfficers, driver);
//    HelperMethods.selectOptionFromDropdownWithValueOf("Contact", selectFromDirectorsOrOfficers, driver);
    HelperMethods.staleElementVisible(directorOrOfficerOption, driver);
//    HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[contains(@class,'appWrapper appRoot')]")));

    driver.findElement(By.xpath("//span[text()='-- Please Select --']")).click();
    HelperMethods.fluentWaitAndCheckVisible(selectFirstPartner, driver);
    HelperMethods.waitAndClick(selectFirstPartner, driver);

    Thread.sleep(3000);
    HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
//    Thread.sleep(500);
    //li[contains(@id,'-CONTACT FIRST CONTACT LAST')]

    Thread.sleep(2000);
    HelperMethods.fluentWaitAndCheckVisible(printedAndSavedConfirmationCheckBox, driver);
    HelperMethods.staleElementClick(printedAndSavedConfirmationCheckBox, driver);
    Thread.sleep(2000);
    HelperMethods.fluentWaitAndCheckVisible(submitButtonExtraProvincial, driver);
    driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    Thread.sleep(4500);
    HelperMethods.staleElementClick(submitButtonExtraProvincial, driver);
    completeFeePaymentDebit();
    File resourcesDirectory = new File("src/main/resources");
    HelperMethods.writeToTextFile(resourcesDirectory +"/BusinessNameForACorporation.txt",randomCorporationName);

}
// ++++++++++
    public void completeContinueCorporationWithNameAndSave() throws InterruptedException {
        String randomCorporationName = HelperMethods.randomString() + HelperMethods.generateRandomNumber(9999,1111)+ " test inc.";


        HelperMethods.fluentWaitAndCheckVisible(willThisCorporationHaveNumberNameNoButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.waitAndClick(willThisCorporationHaveNumberNameNoButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(willThisCorporationHaveNumberNameNoButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.waitAndClick(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameValue, driver);

        HelperMethods.createNewTabAndStayFocused(driver);

        driver.get("https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next");
        System.out.println("-------: '" + "https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next" + ":-------");
        Thread.sleep(1500);
        HelperMethods.createNewTabAndStayFocused(driver);
        Thread.sleep(3500);
        driver.get("https://www-pre.nuans.com/app/scr/corp/nuans/xml/activeReports.xml");
        Thread.sleep(3500);
        driver.getWindowHandle();
        HelperMethods.highLighterMethod(driver,nuansReportNumber); // Nov 12, 2021 - Added highLighterMethod to highlight the object before select
        String reportNumber = nuansReportNumber.getText();
        logger.warn("Report number is: " + reportNumber);
        String reportTitle = nuansReportTitle.getText();
        logger.warn("Report number is: " + reportTitle);
        HelperMethods.switchWindow(driver);

        HelperMethods.waitAndSendKeys(corporationNameValue, reportTitle, driver);
        HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(clearNameButton, driver);
        HelperMethods.waitAndClick(saveAndContinue, driver);

        HelperMethods.fluentLongWaitAndCheckVisible(generalDetailsHeading, driver);
        HelperMethods.fluentLongWaitAndCheckVisible(incorporateOntarioBusinessCorporationBanner, driver);
        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateValue, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);

        HelperMethods.fluentWaitAndClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "484", driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
        HelperMethods.waitAndClick(enterAddressManuallyLink, driver);
        HelperMethods.waitAndSendKeys(streetNumberValue, "1", driver);
        HelperMethods.waitAndSendKeys(streetNameValue, Config.STREET_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(cityValue, Config.CITY_VALUE, driver);
        HelperMethods.waitAndSendKeys(postalCodeValue, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
        HelperMethods.fluentWaitAndClick(fixedNumberOption, driver);
        HelperMethods.waitAndSendKeys(fixedNumberOfDirectorsValue, "1", driver);
        HelperMethods.fluentWaitAndClick(addADirectorButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(addMeAsDirectorButton, driver);
        HelperMethods.fluentWaitAndClick(addMeAsDirectorButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(residentCanadaYesOption, driver);
        HelperMethods.fluentWaitAndClick(residentCanadaYesOption, driver);
        HelperMethods.fluentWaitAndClick(alsoAnIncorporatorYesOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(residentCanadaYesOption, driver);
//        HelperMethods.fluentLongWaitAndCheckVisible(alsoAnIncorporatorYesOption, driver);

        HelperMethods.fluentWaitAndCheckVisible(incorporateOntarioBusinessCorporationBanner, driver);
        HelperMethods.fluentWaitAndCheckVisible(addressLookupField, driver);
        HelperMethods.staleElementClick(doneButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
        HelperMethods.staleElementClick(sharesAndProvisionsPreDefinedTextOption, driver);
//        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsOtherProvisionsHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(incorporatorsHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(generatePDFButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(printedAndSavedConfirmationCheckBox, driver);
        HelperMethods.staleElementClick(printedAndSavedConfirmationCheckBox, driver);

        HelperMethods.fluentWaitAndCheckVisible(reviewAndAuthorizationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(generatePDFButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(submitButton, driver);
        HelperMethods.staleElementClick(submitButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(paymentMethodOption, driver);
//        HelperMethods.selectOptionFromDropdownWithValueOf(Config.DEBIT_CARD_LABEL, paymentMethodOption, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf(Config.CREDIT_CARD_LABEL, paymentMethodOption, driver);
        Thread.sleep(2500);
        HelperMethods.fluentWaitAndCheckVisible(feePaymentContinueButton, driver);
        HelperMethods.staleElementClick(feePaymentContinueButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(paymentMethodInteract, driver);
        HelperMethods.staleElementClick(paymentMethodInteract, driver);
        HelperMethods.staleElementClick(submitMakeAPaymentButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(bankOneButton, driver);
        HelperMethods.staleElementClick(bankOneButton, driver);
        Thread.sleep(2500);
        HelperMethods.fluentWaitAndCheckVisible(loginButton, driver);
        HelperMethods.fluentLongerWaitAndClick(loginButton, driver);
        Thread.sleep(2500);
//        HelperMethods.fluentWaitAndCheckVisible(fromAccountOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(sendNowButton, driver);
        HelperMethods.fluentLongerWaitAndClick(sendNowButton, driver);
        Thread.sleep(2500);
//        HelperMethods.fluentWaitAndCheckVisible(clickingOnNextText, driver);
        HelperMethods.fluentWaitAndCheckVisible(nextButton, driver);
        HelperMethods.fluentLongerWaitAndClick(nextButton, driver);


//        HelperMethods.fluentWaitAndCheckVisible(paymentConfirmationContinueButton, driver);
//        HelperMethods.fluentLongerWaitAndClick(paymentConfirmationContinueButton, driver);

        // May 16, 2022 - button labels have been changed and added new code
        HelperMethods.fluentWaitAndCheckVisible(finalizeTransactionButton, driver);
        HelperMethods.fluentLongerWaitAndClick(finalizeTransactionButton, driver);
    }

    public void completeJurisdictionForContinuanceUnderBusinessCorporation() throws InterruptedException {
        String randomCorporationName = HelperMethods.randomString() + Config.TORONTO_INC;

        HelperMethods.fluentWaitAndCheckVisible(jurisdictionHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(currentCorporationNameLabel, driver);
        HelperMethods.waitAndSendKeys(currentCorporationNameValue, randomCorporationName, driver);
        HelperMethods.waitAndClick(jurisdictionDropdown, driver);
        HelperMethods.waitAndSendKeys(jurisdictionSearchArea, Config.CANADA_LABEL, driver);
        HelperMethods.waitAndClick(jurisdictionSearchResultCanada, driver);

        HelperMethods.fluentWaitAndCheckVisible(currentCorporationNameLabel, driver);
        HelperMethods.waitAndClick(provinceDropdown, driver);
        HelperMethods.waitAndSendKeys(jurisdictionSearchArea, Config.FEDERAL_LABEL, driver);
        HelperMethods.waitAndClick(jurisdictionSearchResultCanada, driver);

        HelperMethods.fluentWaitAndCheckVisible(jurisdictionHeading, driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HelperMethods.fluentWaitAndCheckVisible(jurisdictionDateField, driver);
        //Added Nov 12, 2021 to sync with the application
//        OriginalDateOfIncorporationAmalgamation
//        HelperMethods.highLighterMethod(driver, OriginalDateOfIncorporationAmalgamation);
//        HelperMethods.fluentWaitAndSendKeys(OriginalDateOfIncorporationAmalgamation, "November 12, 2021", driver);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HelperMethods.fluentWaitAndCheckVisible(jurisdictionDateSelectionIcon, driver);
        HelperMethods.highLighterMethod(driver, jurisdictionDateSelectionIcon);
//        HelperMethods.waitAndClick(jurisdictionDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndCheckVisible(jurisdictionDateSelectionIcon, driver);
        HelperMethods.staleElementKeysEnter(jurisdictionDateSelectionIcon, driver);
//        HelperMethods.fluentWaitAndClick(jurisdictionDateSelectionIcon, driver);
//
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndCheckVisible(jurisdictionTodaysDate, driver);
//        HelperMethods.highLighterMethod(driver, jurisdictionTodaysDate);
        HelperMethods.staleElementKeysEnter(jurisdictionTodaysDate, driver);

//        HelperMethods.waitAndClick(jurisdictionTodaysDate, driver);
//        HelperMethods.fluentWaitAndCheckVisible(jurisdictionTodaysDate, driver);
        HelperMethods.fluentWaitAndCheckVisible(jurisdictionHeading, driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndCheckVisible(uploadButton.get(0), driver);

        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");

//      driver.findElement(By.xpath("//div[contains(@class,'appDocumentsContainer continueInAsONBusinessCorp-asyncContainer-wizardBox-jurisdictionTab-serviceinstance-incorporatingDocument-documents')]/following-sibling::div[1]"))
        driver.findElement(By.xpath("//div[contains(@class,'appDocumentsContainer continueInAsONBusinessCorp-asyncContainer-wizardBox-jurisdictionTab-serviceinstance-incorporatingDocument-documents')]/following-sibling::button[1]"))
                .click();

        driver.findElement(By.cssSelector("input[type=file]"))
                .sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");


//        ((JavascriptExecutor) driver).executeScript(
//                "HTMLInputElement.prototype.click = function() {                     " +
//                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
//                        "};                                                                  ");
        Thread.sleep(3000);
        driver.navigate().refresh(); // refreshes the current web page
//        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//button[contains(@class,'appDocumentUploadLink appButton appButtonSecondary appReceiveFocus appClickReady appKeyReady')]")));
        driver.findElement(By.xpath("//button[contains(@class,'appDocumentUploadLink appButton appButtonSecondary appReceiveFocus appClickReady appKeyReady')]")).click();
        // Upload using AutoIT
        try {
            Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Upload.exe");
//            Runtime.getRuntime().exec("wscript " + System.getProperty("user.dir")+ "\\Upload.vbs");
//            System.out.println("'wscript " + System.getProperty("user.dir")+ "\\Upload.vbs' - is executed to upload file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(7000);
//        HelperMethods.fluentWaitAndCheckVisible(uploadButton.get(0), driver);
////        driver.findElement(By.cssSelector("form#viewInstanceForm>div:nth-of-type(2)>div>div>div>div:nth-of-type(3)>div:nth-of-type(4)>div>div>div>div>div>div>div:nth-of-type(8)>div>div:nth-of-type(2)>div>button")).click();
//        driver.findElement(By.xpath("//*[text()=\"Upload\"]")).click();
//        driver.findElement(By.xpath("(//div[@class='appBoxChildren appBlockChildren']//button)[3]")).click();
//        driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
//        driver.findElement(By.xpath("//button[contains(@class,'appDocumentUploadLink appButton appButtonSecondary appReceiveFocus appClickReady appKeyReady')]"))
//                .sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");
//        driver.findElement(By.cssSelector("input[type=file]"))
//                .sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");

        HelperMethods.fluentWaitAndCheckVisible(jurisdictionHeading, driver);
        HelperMethods.staleElementVisible(jurisdictionDropdown, driver);
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        HelperMethods.staleElementVisible(corporationNameValue, driver);
        Thread.sleep(7000);
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void completeCorporationNameAndSaveContinue() throws InterruptedException {
        String randomCorporationName = HelperMethods.randomString() + HelperMethods.generateRandomNumber(9999,1111)+ " test inc.";

        HelperMethods.fluentWaitAndCheckVisible(willThisCorporationHaveNumberNameNoButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.waitAndClick(willThisCorporationHaveNumberNameNoButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(willThisCorporationHaveNumberNameNoButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.waitAndClick(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameValue, driver);

        HelperMethods.createNewTabAndStayFocused(driver);

        driver.get("https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next");
        System.out.println("-------: '" + "https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next" + ":-------");
//        Thread.sleep(1500);
//        HelperMethods.createNewTabAndStayFocused(driver);
//        Thread.sleep(3500);
//        driver.get("https://www-pre.nuans.com/app/scr/corp/nuans/xml/activeReports.xml");
//        Thread.sleep(3500);
//        driver.getWindowHandle();
//        HelperMethods.highLighterMethod(driver,nuansReportNumber); // Nov 12, 2021 - Added highLighterMethod to highlight the object before select
//        String reportNumber = nuansReportNumber.getText();
//        logger.warn("Report number is: " + reportNumber);
//        String reportTitle = nuansReportTitle.getText();
//        logger.warn("Report number is: " + reportTitle);
//        HelperMethods.switchWindow(driver);
//
//        HelperMethods.waitAndSendKeys(corporationNameValue, reportTitle, driver);
//        HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber, driver);
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
        Thread.sleep(3800);
        HelperMethods.waitAndClick(checkNameButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
//        HelperMethods.staleElementClick(saveAndContinue, driver);

//        HelperMethods.staleElementVisible(primaryActivityTypeContainer, driver);
        HelperMethods.staleElementVisible(articlesOfContinuanceBusinessCorporationActTitle, driver);
        Thread.sleep(3800);
        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "484", driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
    }

    public void completeCorporationNameAndSave() throws InterruptedException {
        String randomCorporationName = HelperMethods.randomString() + HelperMethods.generateRandomNumber(9999,1111)+ " test inc.";

        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(willThisCorporationHaveNumberNameNoButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.waitAndClick(willThisCorporationHaveNumberNameNoButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(willThisCorporationHaveNumberNameNoButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.waitAndClick(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameValue, driver);

        HelperMethods.createNewTabAndStayFocused(driver);

        driver.get("https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next");
        System.out.println("-------: '" + "https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next" + ":-------");
        Thread.sleep(1500);
        HelperMethods.createNewTabAndStayFocused(driver);
        Thread.sleep(3500);
        driver.get("https://www-pre.nuans.com/app/scr/corp/nuans/xml/activeReports.xml");
        Thread.sleep(3500);
        driver.getWindowHandle();
        HelperMethods.highLighterMethod(driver,nuansReportNumber); // Nov 12, 2021 - Added highLighterMethod to highlight the object before select
        String reportNumber = nuansReportNumber.getText();
        logger.warn("Report number is: " + reportNumber);
        String reportTitle = nuansReportTitle.getText();
        logger.warn("Report number is: " + reportTitle);
        HelperMethods.switchWindow(driver);

        HelperMethods.waitAndSendKeys(corporationNameValue, reportTitle, driver);
        HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber, driver);
        HelperMethods.fluentWaitAndClick(nuansReportDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
//        HelperMethods.staleElementClick(saveAndContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeContainer, driver);
        HelperMethods.fluentWaitAndCheckVisible(articlesOfContinuanceBusinessCorporationActTitle, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "484", driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
    }
    public void completeCorporationNameFileArticlesOfContinuanceUnderNotForProfitCorporationsAct() throws InterruptedException, IOException {
        File resourcesDirectory = new File("src/main/resources");
        String NFPCABusinessNumber = HelperMethods.readFromTextFile(resourcesDirectory +"/NFPCABusinessNumber.txt");
        System.out.println(NFPCABusinessNumber);
        HelperMethods.fluentWaitAndCheckVisible(notForProfitCorporationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);

        HelperMethods.waitAndSendKeys(currentCorporationName, NFPCABusinessNumber, driver);
       // driver.findElement(By.xpath("//span[text()='If the corporation has changed its name, set out the current corporate name.']/following::input")).sendKeys("values to send");
        HelperMethods.fluentWaitAndCheckVisible(selectFromContryDropdown, driver);
        HelperMethods.staleElementClick(selectFromContryDropdown, driver);
        Thread.sleep(1000);
//        HelperMethods.waitAndSendKeys(partnerTextArea, "Canada", driver);
        HelperMethods.fluentWaitAndCheckVisible(selectCountry, driver);
        HelperMethods.waitAndClick(selectCountry, driver);
        HelperMethods.fluentWaitAndCheckVisible(selectFromProvinceDropdown, driver);
        HelperMethods.staleElementClick(selectFromProvinceDropdown, driver);
        Thread.sleep(1000);
//        HelperMethods.waitAndSendKeys(partnerTextArea, "Canada", driver);
        HelperMethods.fluentWaitAndCheckVisible(selectProvince, driver);
        HelperMethods.waitAndClick(selectProvince, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(nuansReportDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        Thread.sleep(1500);
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
        Thread.sleep(3500);
// trigger the upload
        driver.findElement(By.xpath("//button[contains(@id, '_upload_button')]")).click();

        driver.findElement(By.cssSelector("input[type=file]"))
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1200);

        Thread.sleep(3500);
// trigger the upload
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//span[text()='Upload']")));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Upload']")));
        driver.findElement(By.xpath("(//input[@type='file'])[2]"))
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");

        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(AlsoIncorporatorYes, driver);
        HelperMethods.fluentWaitAndClick(AlsoIncorporatorYes, driver);
        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "484", driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);
        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

        Thread.sleep(500);
        HelperMethods.staleElementVisible(addressLookupField, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE_CR, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(5000);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        // Registered or Head Office Address
        HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_CR, driver);

        Thread.sleep(2000);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

    }
    public void completeCorporationNameIncorporateNotForProfitCorporationSave() throws InterruptedException {
//        String randomCorporationName = HelperMethods.randomString() + " test inc.";
//
//        HelperMethods.fluentWaitAndCheckVisible(notForProfitCorporationHeading, driver);
//
////        HelperMethods.fluentWaitAndCheckVisible(corporationWillHaveEnglishOption, driver);
//        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
////        HelperMethods.waitAndClick(corporationWillHaveEnglishOption, driver);
//        HelperMethods.fluentWaitAndCheckVisible(corporationNameValue, driver);
//
//        HelperMethods.createNewTabAndStayFocused(driver);
//
//        driver.get("https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next");
//        System.out.println("-------: '" + "https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next" + ":-------");
//        Thread.sleep(1500);
//        HelperMethods.createNewTabAndStayFocused(driver);
//        Thread.sleep(3500);
//        driver.get("https://www-pre.nuans.com/app/scr/corp/nuans/xml/activeReports.xml");
//        Thread.sleep(3500);
//        driver.getWindowHandle();
//        HelperMethods.highLighterMethod(driver,nuansReportNumber); // Nov 12, 2021 - Added highLighterMethod to highlight the object before select
//        String reportNumber = nuansReportNumber.getText();
//        logger.warn("Report number is: " + reportNumber);
//        String reportTitle = nuansReportTitle.getText();
//        logger.warn("Report number is: " + reportTitle);
//        HelperMethods.switchWindow(driver);
//
//        HelperMethods.waitAndSendKeys(corporationNameValue, reportTitle, driver);
//        HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber, driver);
//        HelperMethods.fluentWaitAndClick(requestDateForIncorporationDateSelectionIconNotForProfit, driver);
//        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
//        HelperMethods.fluentWaitAndCheckVisible(nuansReportDateSelectionIcon, driver);
//        HelperMethods.fluentWaitAndClick(nuansReportDateSelectionIcon, driver);
//        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
//
//        HelperMethods.waitAndClick(checkNameButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(notForProfitCorporationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(willThisCorporationHaveANumberNameYes, driver);
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndCheckVisible(dateIcon, driver);
        HelperMethods.waitAndClick(dateIcon, driver);
        Thread.sleep(3000);
        HelperMethods.waitAndClick(requestDateForIncorporationTodaysDate, driver);

//label[text()='Yes']
//        HelperMethods.staleElementVisible(primaryActivityTypeContainer, driver);
        HelperMethods.staleElementVisible(articlesOfContinuanceBusinessCorporationActTitle, driver);
        Thread.sleep(3000);
        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "484", driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
    }
    public void completeCorporationNameAndSaveIncorporateNotForProfitCorporation() throws InterruptedException {
        String randomCorporationName = HelperMethods.randomString() + HelperMethods.generateRandomNumber(9999,1111)+ " test inc.";

        HelperMethods.fluentWaitAndCheckVisible(notForProfitCorporationHeading, driver);

        HelperMethods.fluentWaitAndCheckVisible(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.waitAndClick(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameValue, driver);

        HelperMethods.createNewTabAndStayFocused(driver);

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

        //        Thread.sleep(1500);
//        HelperMethods.createNewTabAndStayFocused(driver);
//        Thread.sleep(3500);
//        driver.get("https://www-pre.nuans.com/app/scr/corp/nuans/xml/activeReports.xml");
//        Thread.sleep(3500);
//        driver.getWindowHandle();
//        HelperMethods.highLighterMethod(driver,nuansReportNumber); // Nov 12, 2021 - Added highLighterMethod to highlight the object before select
//        String reportNumber = nuansReportNumber.getText();
//        logger.warn("Report number is: " + reportNumber);
//        String reportTitle = nuansReportTitle.getText();
//        logger.warn("Report number is: " + reportTitle);
//        HelperMethods.switchWindow(driver);
//
//        HelperMethods.waitAndSendKeys(corporationNameValue, reportTitle, driver);
//        HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationDateSelectionIconNotForProfit, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        HelperMethods.fluentWaitAndCheckVisible(nuansReportDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(nuansReportDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        Thread.sleep(5500);
        HelperMethods.waitAndClick(checkNameButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(notForProfitCorporationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);

//        HelperMethods.staleElementVisible(primaryActivityTypeContainer, driver);
        HelperMethods.staleElementVisible(articlesOfContinuanceBusinessCorporationActTitle, driver);
        Thread.sleep(3000);
        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "484", driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
    }
    public void setSelectFromPartnersOption() throws InterruptedException {
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndCheckVisible(selectFromPartnersDropdown, driver);
        HelperMethods.staleElementClick(selectFromPartnersDropdown, driver);
        HelperMethods.waitAndSendKeys(partnerTextArea, "Contact", driver);
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndCheckVisible(selectFirstPartner, driver);
        HelperMethods.waitAndClick(selectFirstPartner, driver);
    }
    public String completeRegisterABusinessNameShort() throws InterruptedException {
        String randomOnlyCorporationName = HelperMethods.randomString();
        String randomCorporationName = randomOnlyCorporationName ;


        HelperMethods.fluentWaitAndCheckVisible(corporationNameValueOCN, driver);
        HelperMethods.fluentWaitAndCheckVisible(checkNameButton, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(corporationNameValueOCN, randomCorporationName, driver);
        logger.warn("Corporation Name is: " + randomCorporationName);
        Thread.sleep(3000);
        HelperMethods.isElementDisplayed(primaryActivityType,driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityType, driver);
        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "Truck transportation", driver); //  Truck transportation  // Clothing accessories and other clothing manufacturing

        Thread.sleep(500);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);
        HelperMethods.staleElementVisible(checkNameButton, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
        HelperMethods.waitAndClick(SaveAndContinueButton, driver);
        // Address  printedAndSavedConfirmationCheckBox
        HelperMethods.fluentWaitAndClick(addressPrincipalPlaceOfBusinessNo, driver);
        Thread.sleep(5000);
        HelperMethods.fluentWaitAndClick(internationalAddress, driver);

        HelperMethods.waitAndSendKeys(internationalAddressLine1, Config.INTERNATIONAL_ADDRESS_LINE1, driver);
        HelperMethods.waitAndSendKeys(internationalCityTown, Config.INTERNATIONAL_CITY_TOWN, driver);
        HelperMethods.waitAndSendKeys(internationalPostalCode, Config.INTERNATIONAL_POSTAL_CODE, driver);
        HelperMethods.fluentWaitAndClick(internationalCountryBusinessName, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body/span/span/span[1]/input")), Config.INTERNATIONAL_COUNTRY, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[contains(text(),'Done')]")), driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
//        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

//label[text()='Director or Officer']
        HelperMethods.waitAndClick(driver.findElement(By.xpath("//label[text()='Director or Officer']")), driver);
//label[text()='Director']
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//span[@role='combobox']//span")));
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//label[text()='CONTACT FIRST CONTACT LAST (DIRECTOR)']")), driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[@role='combobox']//span")), driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//input[@role='searchbox']")), "CONTACT FIRST CONTACT LAST (DIRECTOR)", driver);
        Thread.sleep(1000);
//        HelperMethods.waitAndClick(DirectorsOrOfficers, driver);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='-- Please Select --']")), driver);
        HelperMethods.waitAndSendKeys(DirectorsOrOfficersTextArea, "CONTACT FIRST CONTACT LAST (DIRECTOR)", driver);
        HelperMethods.fluentWaitAndCheckVisible(selectFirstPartner, driver);
        HelperMethods.waitAndClick(selectFirstPartner, driver);
        Thread.sleep(2500);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        Thread.sleep(2500);
        Thread.sleep(2500);

        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label[1]")), driver);
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("(//button[contains(@class,'appButton brRegisterBusinessName-wizardButtonPad-apply')]//span)[2]")), driver);

        return randomOnlyCorporationName;
    }

    public void completeAuthorizationExtraProvincialLimitedLiabilityCompany() throws InterruptedException {
        Thread.sleep(500);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//label[text()='General Manager/Representative']")), driver);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//label[text()='Individual']")), driver);

        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.INTER_CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.INTER_CONTACT_LAST_NAME_VALUE, driver);

        Thread.sleep(500);
        HelperMethods.fluentWaitAndClick(internationalAddress, driver);

        HelperMethods.waitAndSendKeys(internationalAddressLine11, Config.INTERNATIONAL_ADDRESS_LINE1, driver);
        HelperMethods.waitAndSendKeys(internationalCityTown, Config.INTERNATIONAL_CITY_TOWN, driver);
        HelperMethods.waitAndSendKeys(internationalPostalCode, Config.INTERNATIONAL_POSTAL_CODE, driver);

        HelperMethods.fluentWaitAndClick(governingJurisdictionOptionList, driver);
        HelperMethods.fluentWaitAndCheckVisible(governingJurisdictionSearchArea, driver);
        HelperMethods.waitAndSendKeys(governingJurisdictionSearchArea, Config.INTERNATIONAL_COUNTRY, driver);
        HelperMethods.fluentWaitAndClick(searchResultsGoverningJurisdiction, driver);

        Thread.sleep(2000);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

    }
    public void completeAuthorizationExtraProvincialLimitedLiabilityCompanyActingUnderPowerofAttorney() throws InterruptedException {
        Thread.sleep(500);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//label[text()='Person Acting under Power of Attorney']")), driver);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//label[text()='Individual']")), driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//label[text()='Person Acting under Power of Attorney']")), driver);
        Thread.sleep(500);
        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.USA_CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.USA_CONTACT_LAST_NAME_VALUE, driver);

        Thread.sleep(500);
        HelperMethods.staleElementVisible(addressLookupField, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE_CR, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        HelperMethods.waitAndClick(findAddressButton, driver);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        Thread.sleep(5000);
        // Registered or Head Office Address
        HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_CR, driver);

        Thread.sleep(2000);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

    }

    public void reviewAndSubmit() throws InterruptedException {
        Thread.sleep(2300);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label[1]")), driver);
        Thread.sleep(7500);
        HelperMethods.fluentWaitAndCheckVisible(Submit, driver);
        HelperMethods.highLighterMethod(driver, Submit);
        HelperMethods.fluentWaitAndClick(Submit, driver);

    }
    public String completeRegisterABusinessName() throws InterruptedException {
        String randomOnlyCorporationName = HelperMethods.randomString();
        String randomCorporationName = randomOnlyCorporationName ;


        HelperMethods.fluentWaitAndCheckVisible(corporationNameValueOCN, driver);
        HelperMethods.fluentWaitAndCheckVisible(checkNameButton, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(corporationNameValueOCN, randomCorporationName, driver);
        logger.warn("Corporation Name is: " + randomCorporationName);
        Thread.sleep(3000);
        HelperMethods.isElementDisplayed(primaryActivityType,driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityType, driver);
        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "Truck transportation", driver); //  Truck transportation  // Clothing accessories and other clothing manufacturing

        Thread.sleep(500);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);
        HelperMethods.staleElementVisible(checkNameButton, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
        HelperMethods.waitAndClick(SaveAndContinueButton, driver);
        // Address  printedAndSavedConfirmationCheckBox
        HelperMethods.fluentWaitAndClick(addressPrincipalPlaceOfBusinessNo, driver);
        Thread.sleep(5000);
        HelperMethods.fluentWaitAndClick(internationalAddress, driver);

        HelperMethods.waitAndSendKeys(internationalAddressLine1, Config.INTERNATIONAL_ADDRESS_LINE1, driver);
        HelperMethods.waitAndSendKeys(internationalCityTown, Config.INTERNATIONAL_CITY_TOWN, driver);
        HelperMethods.waitAndSendKeys(internationalPostalCode, Config.INTERNATIONAL_POSTAL_CODE, driver);
        HelperMethods.fluentWaitAndClick(internationalCountryBusinessName, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body/span/span/span[1]/input")), Config.INTERNATIONAL_COUNTRY, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[contains(text(),'Done')]")), driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
//        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

//label[text()='Director or Officer']
        HelperMethods.waitAndClick(driver.findElement(By.xpath("//label[text()='Director or Officer']")), driver);
//label[text()='Director']
        HelperMethods.waitAndClick(driver.findElement(By.xpath("//label[text()='Director']")), driver);
//span[text()='First Name']/following::input
//span[text()='Last Name']/following::input
//label[text()='US Address']
//span[text()='Address line 1']/following::input

        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.USA_CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.USA_CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndClick(usAddressOption, driver);
        HelperMethods.waitAndSendKeys(internationalAddressLine1, Config.USA_STREET_NUMBER_VALUE_CR + " " + Config.USA_STREET_NAME_VALUE_CR, driver);
        HelperMethods.waitAndSendKeys(internationalCityTown, Config.USA_CITY_VALUE_CR, driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div[1]/div/form/div[2]/div/div[1]/div/div[3]/div[4]/div/div/div/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div/div/div/div[3]/div/div/div/div/div/div/fieldset/div/div[2]/div/div[2]/div/div[5]/div[2]/span/span[1]/span/span[1]")), driver);


        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//input[@role='searchbox']")), Config.USA_STATE_VALUE_CR, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
        Thread.sleep(1000);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);

//        HelperMethods.robotSendENTER();

        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//span[text()='Zip Code']/following::input")), Config.USA_ZIP_CODE_VALUE_CR, driver);
        HelperMethods.waitAndClick(SaveAndContinueButton, driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label[1]")), driver);
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("(//button[contains(@class,'appButton brRegisterBusinessName-wizardButtonPad-apply')]//span)[2]")), driver);

        return randomOnlyCorporationName;
    }
    public String completeRegisterBusinessNameForNotForProfitCorporation() throws InterruptedException {
        String randomOnlyCorporationName = HelperMethods.randomString();
        String randomCorporationName = randomOnlyCorporationName ;


        HelperMethods.fluentWaitAndCheckVisible(corporationNameValueOCN, driver);
        HelperMethods.fluentWaitAndCheckVisible(checkNameButton, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(corporationNameValueOCN, randomCorporationName, driver);
        logger.warn("Corporation Name is: " + randomCorporationName);
        Thread.sleep(3000);
        HelperMethods.isElementDisplayed(primaryActivityType,driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityType, driver);
        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "Truck transportation", driver); //  Truck transportation  // Clothing accessories and other clothing manufacturing

        Thread.sleep(500);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);
        HelperMethods.staleElementVisible(checkNameButton, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
        HelperMethods.waitAndClick(SaveAndContinueButton, driver);
        // Address  printedAndSavedConfirmationCheckBox
        HelperMethods.fluentWaitAndClick(addressPrincipalPlaceOfBusinessNo, driver);
        Thread.sleep(5000);
        HelperMethods.fluentWaitAndClick(internationalAddress, driver);

        HelperMethods.waitAndSendKeys(internationalAddressLine1, Config.INTERNATIONAL_ADDRESS_LINE1, driver);
        HelperMethods.waitAndSendKeys(internationalCityTown, Config.INTERNATIONAL_CITY_TOWN, driver);
        HelperMethods.waitAndSendKeys(internationalPostalCode, Config.INTERNATIONAL_POSTAL_CODE, driver);
        HelperMethods.fluentWaitAndClick(internationalCountryBusinessName, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body/span/span/span[1]/input")), Config.INTERNATIONAL_COUNTRY, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[contains(text(),'Done')]")), driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
//        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        setSelectFromPartnersOption();
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        Thread.sleep(2000);
//label[text()='Director or Officer']
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//label[text()='Director or Officer']")), driver);
////label[text()='Director']
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//label[text()='Director']")), driver);
////span[text()='First Name']/following::input
////span[text()='Last Name']/following::input
////label[text()='US Address']
////span[text()='Address line 1']/following::input
//
//        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
//        HelperMethods.waitAndSendKeys(firstNameField, Config.USA_CONTACT_FIRST_NAME_VALUE, driver);
//        HelperMethods.waitAndSendKeys(lastNameField, Config.USA_CONTACT_LAST_NAME_VALUE, driver);
//        HelperMethods.waitAndClick(usAddressOption, driver);
//        HelperMethods.waitAndSendKeys(internationalAddressLine1, Config.USA_STREET_NUMBER_VALUE_CR + " " + Config.USA_STREET_NAME_VALUE_CR, driver);
//        HelperMethods.waitAndSendKeys(internationalCityTown, Config.USA_CITY_VALUE_CR, driver);
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div[1]/div/form/div[2]/div/div[1]/div/div[3]/div[4]/div/div/div/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div/div/div/div[3]/div/div/div/div/div/div/fieldset/div/div[2]/div/div[2]/div/div[5]/div[2]/span/span[1]/span/span[1]")), driver);
//
//
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//input[@role='searchbox']")), Config.USA_STATE_VALUE_CR, driver);
//        Thread.sleep(1000);
//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
//        Thread.sleep(1000);
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
//
////        HelperMethods.robotSendENTER();
//
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//span[text()='Zip Code']/following::input")), Config.USA_ZIP_CODE_VALUE_CR, driver);
//        HelperMethods.waitAndClick(SaveAndContinueButton, driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label[1]")), driver);
        Thread.sleep(10000);
        HelperMethods.fluentWaitAndCheckVisible(Submit, driver);
        HelperMethods.fluentWaitAndClick(Submit, driver);
        return randomOnlyCorporationName;
    }
    public String completeRegisterBusinessNameForGeneralPartnership() throws InterruptedException {
        String randomOnlyCorporationName = HelperMethods.randomString();
        String randomCorporationName = randomOnlyCorporationName ;


        HelperMethods.fluentWaitAndCheckVisible(corporationNameValueOCN, driver);
        HelperMethods.fluentWaitAndCheckVisible(checkNameButton, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(corporationNameValueOCN, randomCorporationName, driver);
        logger.warn("Corporation Name is: " + randomCorporationName);
        Thread.sleep(3000);
//        HelperMethods.isElementDisplayed(primaryActivityType,driver);
//        HelperMethods.fluentWaitAndCheckVisible(primaryActivityType, driver);
//        HelperMethods.staleElementClick(primaryActivityType, driver);
//        HelperMethods.waitAndSendKeys(primaryActivityType, "Truck transportation", driver); //  Truck transportation  // Clothing accessories and other clothing manufacturing
//
//        Thread.sleep(500);
//        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
//        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);
        HelperMethods.staleElementVisible(checkNameButton, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
        HelperMethods.waitAndClick(SaveAndContinueButton, driver);
        // Address  printedAndSavedConfirmationCheckBox
        HelperMethods.fluentWaitAndClick(addressPrincipalPlaceOfBusinessNo, driver);
        Thread.sleep(5000);
        HelperMethods.fluentWaitAndClick(internationalAddress, driver);

        HelperMethods.waitAndSendKeys(internationalAddressLine1, Config.INTERNATIONAL_ADDRESS_LINE1, driver);
        HelperMethods.waitAndSendKeys(internationalCityTown, Config.INTERNATIONAL_CITY_TOWN, driver);
        HelperMethods.waitAndSendKeys(internationalPostalCode, Config.INTERNATIONAL_POSTAL_CODE, driver);
        HelperMethods.fluentWaitAndClick(internationalCountryBusinessName, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body/span/span/span[1]/input")), Config.INTERNATIONAL_COUNTRY, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[contains(text(),'Done')]")), driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
//        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        setSelectFromPartnersOption();
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
//label[text()='Director or Officer']
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//label[text()='Director or Officer']")), driver);
////label[text()='Director']
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//label[text()='Director']")), driver);
////span[text()='First Name']/following::input
////span[text()='Last Name']/following::input
////label[text()='US Address']
////span[text()='Address line 1']/following::input
//
//        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
//        HelperMethods.waitAndSendKeys(firstNameField, Config.USA_CONTACT_FIRST_NAME_VALUE, driver);
//        HelperMethods.waitAndSendKeys(lastNameField, Config.USA_CONTACT_LAST_NAME_VALUE, driver);
//        HelperMethods.waitAndClick(usAddressOption, driver);
//        HelperMethods.waitAndSendKeys(internationalAddressLine1, Config.USA_STREET_NUMBER_VALUE_CR + " " + Config.USA_STREET_NAME_VALUE_CR, driver);
//        HelperMethods.waitAndSendKeys(internationalCityTown, Config.USA_CITY_VALUE_CR, driver);
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div[1]/div/form/div[2]/div/div[1]/div/div[3]/div[4]/div/div/div/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div/div/div/div[3]/div/div/div/div/div/div/fieldset/div/div[2]/div/div[2]/div/div[5]/div[2]/span/span[1]/span/span[1]")), driver);
//
//
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//input[@role='searchbox']")), Config.USA_STATE_VALUE_CR, driver);
//        Thread.sleep(1000);
//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
//        Thread.sleep(1000);
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
//
////        HelperMethods.robotSendENTER();
//
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//span[text()='Zip Code']/following::input")), Config.USA_ZIP_CODE_VALUE_CR, driver);
//        HelperMethods.waitAndClick(SaveAndContinueButton, driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label[1]")), driver);
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndClick(Submit, driver);
        return randomOnlyCorporationName;
    }
    public String inCompleteAssignAnOntarioCorporationNumberCR() throws InterruptedException {
        HelperMethods.fluentWaitAndClick(Submit, driver);
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//  ++++
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//a[@class='appPanelError appPanelErrorMore']//span[1]")), driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        logger.warn(driver.findElement(By.xpath("//div[@role='alert']")).getText());
        System.out.println("-------: '" +(driver.findElement(By.xpath("//div[@role='alert']")).getText())+ "' :------");
        Reporter.log("-------: '" +(driver.findElement(By.xpath("//div[@role='alert']")).getText())+ "' :------");
// ++++++++
        String randomOnlyCorporationName = HelperMethods.randomString();
        String randomCorporationName = randomOnlyCorporationName + " test inc.";

        HelperMethods.fluentWaitAndCheckVisible(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonOCN, driver);
        HelperMethods.waitAndClick(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameValueOCN, driver);
        HelperMethods.fluentWaitAndCheckVisible(checkNameButton, driver);

        HelperMethods.waitAndSendKeys(corporationNameValueOCN, randomCorporationName, driver);
        logger.warn("Corporation Name is: " + randomCorporationName);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationDateSelectionIconNotForProfit, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        HelperMethods.fluentWaitAndCheckVisible(nuansReportDateSelectionIcon, driver);

        HelperMethods.staleElementVisible(checkNameButton, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
//        HelperMethods.fluentWaitAndCheckVisible(notForProfitCorporationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateSelectionIcon, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonOCN, driver);
        HelperMethods.fluentWaitAndClick(Submit, driver);
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//a[@class='appPanelError appPanelErrorMore']//span[1]")), driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        logger.warn(driver.findElement(By.xpath("//div[@role='alert']")).getText());
        System.out.println("-------: '" +(driver.findElement(By.xpath("//div[@role='alert']")).getText())+ "' :------");
        Reporter.log("-------: '" +(driver.findElement(By.xpath("//div[@role='alert']")).getText())+ "' :------");

        Thread.sleep(2000);
        HelperMethods.staleElementVisible(entityTypeOption, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf(Config.LOAN_AND_TRUST_CORPORATION_LABEL, entityTypeOption, driver);
        Thread.sleep(800);
        HelperMethods.staleElementVisible(exemptFromFilingOption, driver);
        Thread.sleep(2000);
        HelperMethods.waitAndClick(exemptFromFilingOption, driver);

        HelperMethods.staleElementVisible(addressLookupField, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE_CR, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(5000);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        // Registered or Head Office Address
        HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_CR, driver);

        HelperMethods.fluentWaitAndClick(Submit, driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//a[@class='appPanelError appPanelErrorMore']//span[1]")), driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        logger.warn(driver.findElement(By.xpath("//div[@role='alert']")).getText());
        System.out.println("-------: '" +(driver.findElement(By.xpath("//div[@role='alert']")).getText())+ "' :------");
        Reporter.log("-------: '" +(driver.findElement(By.xpath("//div[@role='alert']")).getText())+ "' :------");


//        HelperMethods.staleElementVisible(primaryActivityTypeContainer, driver);
        HelperMethods.fluentWaitAndCheckVisible(articlesOfContinuanceBusinessCorporationActTitle, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityType, driver);
        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "Truck transportation", driver); //  Truck transportation  // Clothing accessories and other clothing manufacturing

        Thread.sleep(500);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        HelperMethods.fluentWaitAndClick(Submit, driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//a[@class='appPanelError appPanelErrorMore']//span[1]")), driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        logger.warn(driver.findElement(By.xpath("//div[@role='alert']")).getText());
        System.out.println("-------: '" +(driver.findElement(By.xpath("//div[@role='alert']")).getText())+ "' :------");
        Reporter.log("-------: '" + (driver.findElement(By.xpath("//div[@role='alert']")).getText()) + "' :------");

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonOCN, driver);
        HelperMethods.staleElementVisible(stateOption, driver);
        HelperMethods.waitAndClick(stateOption, driver);
        HelperMethods.waitAndClick(provinceOptionOntario, driver);

//        Thread.sleep(1000);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        HelperMethods.fluentLongerWaitAndCheckVisible(submitButton, driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("(//button[contains(@class,'appButton assignOntarioCorporationNumber-asyncContainer-buttonPad-apply')]//span)[2]")), driver);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//a[@class='appPanelError appPanelErrorMore']//span[1]")), driver);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        logger.warn(driver.findElement(By.xpath("//div[@role='alert']")).getText());
//        System.out.println("-------: '" +(driver.findElement(By.xpath("//div[@role='alert']")).getText())+ "' :------");
//        Reporter.log("-------: '" + (driver.findElement(By.xpath("//div[@role='alert']")).getText()) + "' :------");


        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
        Thread.sleep(500);
        HelperMethods.fluentWaitAndClick(fixedNumberOption, driver);
        Thread.sleep(500);
        HelperMethods.waitAndSendKeys(fixedNumberOfDirectorsValue, "1", driver);
        HelperMethods.fluentWaitAndClick(addADirectorButton, driver);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("(//button[contains(@class,'appButton assignOntarioCorporationNumber-asyncContainer-buttonPad-apply')]//span)[2]")), driver);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//a[@class='appPanelError appPanelErrorMore']//span[1]")), driver);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        logger.warn(driver.findElement(By.xpath("//div[@role='alert']")).getText());
//        System.out.println("-------: '" +(driver.findElement(By.xpath("//div[@role='alert']")).getText())+ "' :------");
//        Reporter.log("-------: '" + (driver.findElement(By.xpath("//div[@role='alert']")).getText()) + "' :------");

        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(submitButtonOCN, driver);
//        HelperMethods.fluentLongerWaitAndCheckVisible(submitButton, driver);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("(//button[contains(@class,'appButton assignOntarioCorporationNumber-asyncContainer-buttonPad-apply')]//span)[2]")), driver);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//a[@class='appPanelError appPanelErrorMore']//span[1]")), driver);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        logger.warn(driver.findElement(By.xpath("//div[@role='alert']")).getText());
        System.out.println("-------: '" +(driver.findElement(By.xpath("//div[@role='alert']")).getText())+ "' :------");
        Reporter.log("-------: '" + (driver.findElement(By.xpath("//div[@role='alert']")).getText()) + "' :------");

        HelperMethods.waitAndSendKeys(firstNameField, Config.INTER_CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.INTER_CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndClick(internationalAddress, driver);
        HelperMethods.waitAndSendKeys(internationalAddressLine1, Config.INTERNATIONAL_ADDRESS_LINE1, driver);
        HelperMethods.waitAndSendKeys(internationalCityTown, Config.INTERNATIONAL_CITY_TOWN, driver);
        HelperMethods.waitAndSendKeys(internationalPostalCode, Config.INTERNATIONAL_POSTAL_CODE, driver);
        HelperMethods.fluentWaitAndClick(internationalCountry, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body/span/span/span[1]/input")), Config.INTERNATIONAL_COUNTRY, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[contains(text(),'Done')]")), driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
//        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(doneButtonNotForProfit, driver);
        HelperMethods.staleElementVisible(doneButtonNotForProfit, driver);
        HelperMethods.staleElementClick(doneButtonNotForProfit, driver);
        Thread.sleep(800);


        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndClick(submitButtonOCN, driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("(//button[contains(@class,'appButton assignOntarioCorporationNumber-asyncContainer-buttonPad-apply')]//span)[2]")), driver);
//        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//a[@class='appPanelError appPanelErrorMore']//span[1]")), driver);
//        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
//        logger.warn(driver.findElement(By.xpath("//div[@role='alert']")).getText());
        System.out.println("-------: '" +(driver.findElement(By.xpath("//div[@role='alert']")).getText())+ "' :------");
        Reporter.log("-------: '" + (driver.findElement(By.xpath("//div[@role='alert']")).getText()) + "' :------");

        HelperMethods.staleElementVisible(declarationCheckBox, driver);
        Thread.sleep(800);
        HelperMethods.staleElementClick(declarationCheckBox, driver);

        Thread.sleep(1500);
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
//        Thread.sleep(1200);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].style.display='block';", uploadButtonInput);
        Thread.sleep(3500);
// trigger the upload
//        HelperMethods.staleElementClick(uploadButtonInput, driver);
        driver.findElement(By.xpath("//button[contains(@id, '_upload_button')]")).click();

        driver.findElement(By.cssSelector("input[type=file]"))
//                .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1200);

        HelperMethods.staleElementVisible(contactInformationRemoveButton, driver);
//        HelperMethods.fluentWaitAndClick(submitButtonOCN, driver);
//        if (HelperMethods.isElementDisplayed(PleaseUploadTheConstatingDocument, driver)) {
//            HelperMethods.waitAndClick(Submit, driver);
//        }
        return randomOnlyCorporationName;
    }
    public String completeAssignAnOntarioCorporationNumberCR() throws InterruptedException {
        String randomOnlyCorporationName = HelperMethods.randomString();
        String randomCorporationName = randomOnlyCorporationName + " test inc.";

        HelperMethods.fluentWaitAndCheckVisible(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonOCN, driver);
        HelperMethods.waitAndClick(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameValueOCN, driver);
        HelperMethods.fluentWaitAndCheckVisible(checkNameButton, driver);

        HelperMethods.waitAndSendKeys(corporationNameValueOCN, randomCorporationName, driver);
        logger.warn("Corporation Name is: " + randomCorporationName);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationDateSelectionIconNotForProfit, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        HelperMethods.fluentWaitAndCheckVisible(nuansReportDateSelectionIcon, driver);

        HelperMethods.staleElementVisible(checkNameButton, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
//        HelperMethods.fluentWaitAndCheckVisible(notForProfitCorporationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateSelectionIcon, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonOCN, driver);

        Thread.sleep(2000);
        HelperMethods.staleElementVisible(entityTypeOption, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf(Config.LOAN_AND_TRUST_CORPORATION_LABEL, entityTypeOption, driver);
        Thread.sleep(800);
        HelperMethods.staleElementVisible(exemptFromFilingOption, driver);
        Thread.sleep(2000);
        HelperMethods.waitAndClick(exemptFromFilingOption, driver);

        HelperMethods.staleElementVisible(addressLookupField, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE_CR, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        HelperMethods.waitAndClick(findAddressButton, driver);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        Thread.sleep(5000);
        // Registered or Head Office Address
        HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_CR, driver);


//        HelperMethods.staleElementVisible(primaryActivityTypeContainer, driver);
        HelperMethods.fluentWaitAndCheckVisible(articlesOfContinuanceBusinessCorporationActTitle, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityType, driver);
        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "Truck transportation", driver); //  Truck transportation  // Clothing accessories and other clothing manufacturing

        Thread.sleep(500);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonOCN, driver);
        HelperMethods.staleElementVisible(stateOption, driver);
        HelperMethods.waitAndClick(stateOption, driver);
        HelperMethods.waitAndClick(provinceOptionOntario, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
        Thread.sleep(500);
        HelperMethods.fluentWaitAndClick(fixedNumberOption, driver);
        Thread.sleep(500);
        HelperMethods.waitAndSendKeys(fixedNumberOfDirectorsValue, "1", driver);
        HelperMethods.fluentWaitAndClick(addADirectorButton, driver);

        HelperMethods.waitAndSendKeys(firstNameField, Config.INTER_CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.INTER_CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndClick(internationalAddress, driver);
        HelperMethods.waitAndSendKeys(internationalAddressLine1, Config.INTERNATIONAL_ADDRESS_LINE1, driver);
        HelperMethods.waitAndSendKeys(internationalCityTown, Config.INTERNATIONAL_CITY_TOWN, driver);
        HelperMethods.waitAndSendKeys(internationalPostalCode, Config.INTERNATIONAL_POSTAL_CODE, driver);
        HelperMethods.fluentWaitAndClick(internationalCountry, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body/span/span/span[1]/input")), Config.INTERNATIONAL_COUNTRY, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[contains(text(),'Done')]")), driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
//        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(doneButtonNotForProfit, driver);
        HelperMethods.staleElementVisible(doneButtonNotForProfit, driver);
        HelperMethods.staleElementClick(doneButtonNotForProfit, driver);
        Thread.sleep(800);

        HelperMethods.staleElementVisible(declarationCheckBox, driver);
        Thread.sleep(800);
        HelperMethods.staleElementClick(declarationCheckBox, driver);

        Thread.sleep(1500);
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
//        Thread.sleep(1200);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].style.display='block';", uploadButtonInput);
        Thread.sleep(3500);
// trigger the upload
//        HelperMethods.staleElementClick(uploadButtonInput, driver);
        driver.findElement(By.xpath("//button[contains(@id, '_upload_button')]")).click();

        driver.findElement(By.cssSelector("input[type=file]"))
//                .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1200);

        HelperMethods.staleElementVisible(contactInformationRemoveButton, driver);
        HelperMethods.fluentWaitAndClick(submitButtonOCN, driver);
        if (HelperMethods.isElementDisplayed(PleaseUploadTheConstatingDocument, driver)) {
            HelperMethods.waitAndClick(Submit, driver);
        }
        return randomOnlyCorporationName;
    }
    public String completeGeneralPartnershipFirmName() throws InterruptedException {
        String randomOnlyCorporationName = HelperMethods.randomString();
        String randomCorporationName = randomOnlyCorporationName;
        HelperMethods.fluentWaitAndCheckVisible(corporationNameValueOCN, driver);
        HelperMethods.fluentWaitAndCheckVisible(checkNameButton, driver);

        HelperMethods.waitAndSendKeys(corporationNameValueOCN, randomCorporationName, driver);
        logger.warn("General Partnership Firm Name is: " + randomCorporationName);

        HelperMethods.staleElementVisible(checkNameButton, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);

        Thread.sleep(2000);
        HelperMethods.staleElementVisible(primaryActivityType, driver);
        HelperMethods.fluentWaitAndClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "truck transportation", driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);
        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.waitAndClick(saveAndContinue, driver);
        return randomOnlyCorporationName;
    }

    public String completeAssignAnExtraProvincialLicenceForAForeignCorporationNumberCR() throws InterruptedException {
        String randomOnlyCorporationName = HelperMethods.randomString();
        String randomCorporationName = randomOnlyCorporationName + " test inc.";

        HelperMethods.fluentWaitAndCheckVisible(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonOCN, driver);
//        HelperMethods.waitAndClick(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameValueOCN, driver);
        HelperMethods.fluentWaitAndCheckVisible(checkNameButton, driver);

        HelperMethods.waitAndSendKeys(corporationNameValueOCN, randomCorporationName, driver);
        logger.warn("Corporation Name is: " + randomCorporationName);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationDateSelectionIconNotForProfit, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        HelperMethods.fluentWaitAndCheckVisible(nuansReportDateSelectionIcon, driver);

        HelperMethods.staleElementVisible(checkNameButton, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
//        HelperMethods.fluentWaitAndCheckVisible(notForProfitCorporationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateSelectionIcon, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonOCN, driver);

        Thread.sleep(2000);
        HelperMethods.staleElementVisible(entityTypeOption, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf(Config.LOAN_AND_TRUST_CORPORATION_LABEL, entityTypeOption, driver);
        Thread.sleep(800);
        HelperMethods.staleElementVisible(exemptFromFilingOption, driver);
        Thread.sleep(2000);
        HelperMethods.waitAndClick(exemptFromFilingOption, driver);

        HelperMethods.staleElementVisible(addressLookupField, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE_CR, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(5000);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        // Registered or Head Office Address
        HelperMethods.waitAndSendKeys(streetNumber, Config.STREET_NUMBER_VALUE_CR, driver);


//        HelperMethods.staleElementVisible(primaryActivityTypeContainer, driver);
        HelperMethods.fluentWaitAndCheckVisible(articlesOfContinuanceBusinessCorporationActTitle, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityType, driver);
        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "Truck transportation", driver); //  Truck transportation  // Clothing accessories and other clothing manufacturing

        Thread.sleep(500);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonOCN, driver);
        HelperMethods.staleElementVisible(stateOption, driver);
        HelperMethods.waitAndClick(stateOption, driver);
        HelperMethods.waitAndClick(provinceOptionOntario, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
        Thread.sleep(500);
        HelperMethods.fluentWaitAndClick(fixedNumberOption, driver);
        Thread.sleep(500);
        HelperMethods.waitAndSendKeys(fixedNumberOfDirectorsValue, "1", driver);
        HelperMethods.fluentWaitAndClick(addADirectorButton, driver);

        HelperMethods.waitAndSendKeys(firstNameField, Config.INTER_CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.INTER_CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndClick(internationalAddress, driver);
        HelperMethods.waitAndSendKeys(internationalAddressLine1, Config.INTERNATIONAL_ADDRESS_LINE1, driver);
        HelperMethods.waitAndSendKeys(internationalCityTown, Config.INTERNATIONAL_CITY_TOWN, driver);
        HelperMethods.waitAndSendKeys(internationalPostalCode, Config.INTERNATIONAL_POSTAL_CODE, driver);
        HelperMethods.fluentWaitAndClick(internationalCountry, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body/span/span/span[1]/input")), Config.INTERNATIONAL_COUNTRY, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")), driver);
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[contains(text(),'Done')]")), driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
//        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(doneButtonNotForProfit, driver);
        HelperMethods.staleElementVisible(doneButtonNotForProfit, driver);
        HelperMethods.staleElementClick(doneButtonNotForProfit, driver);
        Thread.sleep(800);

        HelperMethods.staleElementVisible(declarationCheckBox, driver);
        Thread.sleep(800);
        HelperMethods.staleElementClick(declarationCheckBox, driver);

        Thread.sleep(1500);
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
//        Thread.sleep(1200);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].style.display='block';", uploadButtonInput);
        Thread.sleep(3500);
// trigger the upload
//        HelperMethods.staleElementClick(uploadButtonInput, driver);
        driver.findElement(By.xpath("//button[contains(@id, '_upload_button')]")).click();

        driver.findElement(By.cssSelector("input[type=file]"))
//                .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1200);

        HelperMethods.staleElementVisible(contactInformationRemoveButton, driver);
        HelperMethods.fluentWaitAndClick(submitButtonOCN, driver);
        if (HelperMethods.isElementDisplayed(PleaseUploadTheConstatingDocument, driver)) {
            HelperMethods.waitAndClick(Submit, driver);
        }
        return randomOnlyCorporationName;
    }
    public void completeAssignAnOntarioCorporationNumber() throws InterruptedException {
        String randomCorporationName = HelperMethods.randomString() + " test inc.";

        HelperMethods.fluentWaitAndCheckVisible(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonOCN, driver);
        HelperMethods.waitAndClick(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameValueOCN, driver);
        HelperMethods.fluentWaitAndCheckVisible(checkNameButton, driver);

        HelperMethods.waitAndSendKeys(corporationNameValueOCN, randomCorporationName, driver);
        logger.warn("Corporation Name is: " + randomCorporationName);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationDateSelectionIconNotForProfit, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        HelperMethods.fluentWaitAndCheckVisible(nuansReportDateSelectionIcon, driver);

        HelperMethods.staleElementVisible(checkNameButton, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
//        HelperMethods.fluentWaitAndCheckVisible(notForProfitCorporationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateSelectionIcon, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonOCN, driver);

        Thread.sleep(2000);
        HelperMethods.staleElementVisible(entityTypeOption, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf(Config.AGENCIES_BOARDS_COMMISSIONS_LABEL, entityTypeOption, driver);
        Thread.sleep(800);
        HelperMethods.staleElementVisible(exemptFromFilingOption, driver);
        Thread.sleep(2000);
        HelperMethods.waitAndClick(exemptFromFilingOption, driver);

        HelperMethods.staleElementVisible(addressLookupField, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.staleElementVisible(findAddressButton, driver);
        HelperMethods.waitAndClick(findAddressButton, driver);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        Thread.sleep(5000);
//        HelperMethods.staleElementVisible(primaryActivityTypeContainer, driver);
        HelperMethods.fluentWaitAndCheckVisible(articlesOfContinuanceBusinessCorporationActTitle, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityType, driver);
        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "Truck transportation", driver);
        Thread.sleep(500);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonOCN, driver);
        HelperMethods.staleElementVisible(stateOption, driver);
        HelperMethods.waitAndClick(stateOption, driver);
        HelperMethods.waitAndClick(provinceOptionOntario, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
        Thread.sleep(500);
        HelperMethods.fluentWaitAndClick(fixedNumberOption, driver);
        Thread.sleep(500);
        HelperMethods.waitAndSendKeys(fixedNumberOfDirectorsValue, "1", driver);
        HelperMethods.fluentWaitAndClick(addADirectorButton, driver);

        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(doneButtonNotForProfit, driver);
        HelperMethods.staleElementVisible(doneButtonNotForProfit, driver);
        HelperMethods.staleElementClick(doneButtonNotForProfit, driver);
        Thread.sleep(800);

        HelperMethods.staleElementVisible(declarationCheckBox, driver);
        Thread.sleep(800);
        HelperMethods.staleElementClick(declarationCheckBox, driver);

        Thread.sleep(1500);
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
//        Thread.sleep(1200);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].style.display='block';", uploadButtonInput);
        Thread.sleep(3500);
// trigger the upload
//        HelperMethods.staleElementClick(uploadButtonInput, driver);
        driver.findElement(By.xpath("//button[contains(@id, '_upload_button')]")).click();

        driver.findElement(By.cssSelector("input[type=file]"))
//                .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1200);

        HelperMethods.staleElementVisible(contactInformationRemoveButton, driver);
        HelperMethods.fluentWaitAndClick(submitButtonOCN, driver);
       if (HelperMethods.isElementDisplayed(PleaseUploadTheConstatingDocument, driver)) {
           HelperMethods.waitAndClick(Submit, driver);
       }
    }

    public void completeCorporationNameAndSaveIncorporateExtraProvincialLicence(String browser) throws InterruptedException {
        String randomCorporationName = HelperMethods.randomString() + HelperMethods.generateRandomNumber(9999,1111)+ " test inc.";
     //   String reportNumber, reportTitle;
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);

        HelperMethods.fluentWaitAndCheckVisible(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.waitAndClick(corporationWillHaveEnglishOption, driver);
        Thread.sleep(500);
        HelperMethods.staleElementVisible(corporationNameValue, driver);

        HelperMethods.createNewTabAndStayFocused(driver);

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
        //        Thread.sleep(1500);
//        HelperMethods.createNewTabAndStayFocused(driver);
//        Thread.sleep(3500);
//        driver.get("https://www-pre.nuans.com/app/scr/corp/nuans/xml/activeReports.xml");
//        Thread.sleep(3500);
//        driver.getWindowHandle();
//        HelperMethods.highLighterMethod(driver,nuansReportNumber); // Nov 12, 2021 - Added highLighterMethod to highlight the object before select
//        reportNumber = nuansReportNumber.getText();
//        logger.warn("Report number is: " + reportNumber);
//        reportTitle = nuansReportTitle.getText();
//        logger.warn("Report title is: " + reportTitle);
//        HelperMethods.switchWindow(driver);
//
//        HelperMethods.waitAndSendKeys(corporationNameValue, reportTitle, driver);
//        HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber, driver);

        Thread.sleep(3500);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationDateSelectionIconExtraProvincial, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        HelperMethods.fluentWaitAndCheckVisible(nuansReportDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(nuansReportDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);

        HelperMethods.staleElementVisible(checkNameButton, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(notForProfitCorporationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateSelectionIconExtraProvincial, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        Thread.sleep(1300);
//        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeContainer, driver);
        HelperMethods.fluentWaitAndCheckVisible(articlesOfContinuanceBusinessCorporationActTitle, driver);
        Thread.sleep(1300);
        HelperMethods.staleElementVisible(primaryActivityType, driver);
        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "484", driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
    }

    public String completeCorporationNameAndSaveExtraProvincialCorporation(String browser) throws InterruptedException, IOException {
        String randomCorporationName = HelperMethods.randomString() + HelperMethods.generateRandomNumber(9999, 1111) + " test inc.";
        String reportNumber, reportTitle;
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        logger.warn("https://onbissupporttest%40ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next");

        HelperMethods.fluentWaitAndCheckVisible(corporationWillHaveEnglishOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.waitAndClick(corporationWillHaveEnglishOption, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementVisible(corporationNameValue, driver);
        Thread.sleep(1000);
//        System.out.println ("https://onbissupporttest%40ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next");
        System.out.println("https://www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next");
        if (!browser.equals("internetExplorer") || browser.equals("Edge")) {
            HelperMethods.createNewTabAndStayFocused(driver);
        }
        String NuansReportNumber = null;
        if (browser.equals("internetExplorer") || browser.equals("Edge")) {
            File resourcesDirectory = new File("src/main/resources");
            reportNumber = HelperMethods.readFromTextFile(resourcesDirectory + "/nuansReportNumber.txt");
            System.out.println(reportNumber);
            Thread.sleep(500);
            reportTitle = HelperMethods.readFromTextFile(resourcesDirectory + "/nuansReportTitle.txt");
            Reporter.log("Corporation Name is: " + reportTitle);
            System.out.println(reportTitle);
            Thread.sleep(500);
            HelperMethods.deleteFile(resourcesDirectory + "/nuansReportTitle.txt");
            HelperMethods.deleteFile(resourcesDirectory + "/nuansReportNumber.txt");
//            System.out.println(HelperMethods.readFromTextFile(resourcesDirectory +"/nuansReportTitle.txt"));
//            System.out.println(HelperMethods.readFromTextFile(resourcesDirectory +"/nuansReportNumber.txt"));
//            Thread.sleep(5500);
//            driver.navigate().to("https://onbissupporttest%40ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next");
//
//            Thread.sleep(5500);
//            driver.navigate().to("https://www-pre.nuans.com/app/scr/corp/nuans/xml/activeReports.xml");
//            Thread.sleep(3500);
//            driver.getWindowHandle();
//            HelperMethods.highLighterMethod(driver,nuansReportNumber); // Nov 12, 2021 - Added highLighterMethod to highlight the object before select
////            Thread.sleep(1500);
//            HelperMethods.getLatestWindowFocused(driver);
////            logger.warn("current window url is: " + driver.getCurrentUrl());
//            reportNumber = nuansReportNumberIE.getText();
//            logger.warn("Report number is: " + reportNumber);
//            reportTitle = nuansReportTitleIE.getText().replace("<report_title>", "").replace("</report_title>", "");
//            logger.warn("Report Title is: " + reportTitle);

        } else {
            // Thread.sleep(10000);
            driver.get("https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next");
            System.out.println("-------: '" + "https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next" + ":-------");
            Thread.sleep(1500);
            HelperMethods.highLighterMethod(driver, getNuansReportNumber); // Nov 12, 2021 - Added highLighterMethod to highlight the object before select
            NuansReportNumber = getNuansReportNumber.getText();
            logger.warn("Report number is: " + NuansReportNumber);
            logger.warn("Corporation Name is: " + randomCorporationName);
            Thread.sleep(2800);

//            Thread.sleep(10000);
//            HelperMethods.createNewTabAndStayFocused(driver);
//            Thread.sleep(3500);
//            driver.get("https://www-pre.nuans.com/app/scr/corp/nuans/xml/activeReports.xml");
//            Thread.sleep(10000);
//            driver.getWindowHandle();
//            HelperMethods.highLighterMethod(driver,nuansReportNumber); // Nov 12, 2021 - Added highLighterMethod to highlight the object before select
//            reportNumber = nuansReportNumber.getText();
//            logger.warn("Report number is: " + reportNumber);
//            reportTitle = nuansReportTitle.getText();
//            logger.warn("Report title is: " + reportTitle);
        }
        HelperMethods.switchWindow(driver);
        Thread.sleep(3500);
        HelperMethods.waitAndSendKeys(corporationNameValue, randomCorporationName, driver);
        Thread.sleep(3500);
        HelperMethods.waitAndSendKeys(nuansReportValue, NuansReportNumber, driver);
        //HelperMethods.waitAndSendKeys(nuansReportValue, reportNumber1, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationDateSelectionIconExtraProvincial, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        HelperMethods.fluentWaitAndCheckVisible(nuansReportDateSelectionIcon, driver);
//        HelperMethods.fluentWaitAndClick(nuansReportDateSelectionIcon, driver);
//        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        Thread.sleep(3500);
        HelperMethods.staleElementVisible(checkNameButton, driver);
        HelperMethods.waitAndClick(checkNameButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(notForProfitCorporationHeading, driver);
        Thread.sleep(1500);
//        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateSelectionIconExtraProvincial, driver);
        Thread.sleep(1300);
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        Thread.sleep(1300);

//        HelperMethods.staleElementVisible(primaryActivityTypeContainer, driver);
        HelperMethods.fluentWaitAndCheckVisible(articlesOfContinuanceBusinessCorporationActTitle, driver);
        Thread.sleep(6000);
        HelperMethods.staleElementVisible(primaryActivityType, driver);
        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "484", driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        return randomCorporationName;
    }


    public String extraProvincialCorporation;

    public String getExtraProvincialCorporation() {
        return extraProvincialCorporation;
    }

    public void setExtraProvincialCorporation(String extraProvincialCorporation) {
        this.extraProvincialCorporation = extraProvincialCorporation;
    }

    public void searchCorporationAndSelectResult() {
        HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(getExtraProvincialCorporation());
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(searchResultsCorporation, driver);
        HelperMethods.staleElementClick(searchResultsCorporation, driver);
    }
    public void searchCorporationByName( String businessName) {
        HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(businessName);
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(searchResultsCorporation, driver);
        HelperMethods.staleElementClick(searchResultsCorporation, driver);
    }
    public void completeApplicantAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Applicant']")), driver);
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[text()='Applicant']")), driver);
        Thread.sleep(3500);
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//span[text()='Applicant Name']/following::input")));
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Applicant Name']/following::input")), driver);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//span[text()='Applicant Name']/following::input")), Config.CONTACT_FIRST_NAME_VALUE, driver);

        HelperMethods.selectOptionFromDropdownselectByIndex(2, driver.findElement(By.xpath("//div[contains(@class,'appGroupSelector appRestricted')]//select[1]")), driver);
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
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
    }
    public void revivalNameRequiredStatements() {
        HelperMethods.fluentWaitAndCheckVisible(SaveAndContinueButton, driver);
        HelperMethods.waitAndClick(SaveAndContinueButton, driver);
//        HelperMethods.fluentWaitAndCheckVisible(printedAndSavedConfirmationCheckBox, driver);
//        HelperMethods.staleElementClick(printedAndSavedConfirmationCheckBox, driver);
//        HelperMethods.fluentWaitAndCheckVisible(SaveAndContinueButton, driver);
//        HelperMethods.waitAndClick(SaveAndContinueButton, driver);
//        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//span[text()='Applicant Name']/following::input")));
//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Applicant Name']/following::input")), driver);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//span[text()='Applicant Name']/following::input")), Config.CONTACT_FIRST_NAME_VALUE, driver);

    }
    public void completeAddressAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Address']")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[text()='Address']")), driver);

//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndClick(enterAddressManuallyLink, driver);
//        HelperMethods.staleElementVisible(enterAddressManuallyLink, driver);
//        Thread.sleep(500);
//        HelperMethods.waitAndSendKeys(streetNumberValue, "1", driver);
//        HelperMethods.waitAndSendKeys(streetNameValue, Config.STREET_NAME_VALUE, driver);
//        HelperMethods.waitAndSendKeys(cityValue, Config.CITY_VALUE, driver);
//        HelperMethods.waitAndSendKeys(postalCodeValue, Config.POSTAL_CODE_VALUE, driver);
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
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
    }
    public void completeCorporationAddressAndSave() throws InterruptedException {
//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndClick(enterAddressManuallyLink, driver);
//        HelperMethods.staleElementVisible(enterAddressManuallyLink, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(500);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.waitAndSendKeys(streetNumberValue, "30", driver);
//        HelperMethods.waitAndSendKeys(streetNameValue, Config.STREET_NAME_VALUE, driver);
//        HelperMethods.waitAndSendKeys(cityValue, Config.CITY_VALUE, driver);
//        HelperMethods.waitAndSendKeys(postalCodeValue, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
    }
    public void completeCorporationAddressUSAAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(USAddressOption, driver);
        HelperMethods.waitAndClick(USAddressOption, driver);
//        HelperMethods.staleElementVisible(enterAddressManuallyLink, driver);
        HelperMethods.staleElementVisible(streetNumberValue, driver);
        HelperMethods.waitAndSendKeys(streetNumberValue, Config.USA_STREET_NUMBER_VALUE_CR, driver);
        HelperMethods.waitAndSendKeys(streetNameValue, Config.USA_STREET_NAME_VALUE_CR, driver);
        HelperMethods.waitAndSendKeys(cityValue, Config.USA_CITY_VALUE_CR, driver);
        HelperMethods.waitAndClick(stateOption, driver);
        HelperMethods.waitAndClick(stateOptionArizona, driver);
        HelperMethods.waitAndSendKeys(postalCodeValue, Config.USA_ZIP_CODE_VALUE_CR, driver);
//        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE_CR, driver);
//        HelperMethods.fluentWaitAndCheckVisible(findAddressButton, driver);
//        HelperMethods.waitAndClick(findAddressButton, driver);
//        Thread.sleep(2100);
//        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
//        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
//        HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_CR, driver);
        HelperMethods.scrollIntoViewForClick(saveAndContinue, driver);
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }
    public void completeCorporationAddressAndSaveForeignCorpAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(USAddressOption, driver);
        Thread.sleep(3000);
        HelperMethods.waitAndClick(USAddressOption, driver);
//        HelperMethods.staleElementVisible(enterAddressManuallyLink, driver);
        HelperMethods.staleElementVisible(streetNumberValue, driver);
        HelperMethods.waitAndSendKeys(streetNumberValue, "1", driver);
        HelperMethods.waitAndSendKeys(streetNameValue, Config.STREET_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(cityValue, Config.CITY_VALUE, driver);
        HelperMethods.waitAndClick(stateOption, driver);
        HelperMethods.waitAndClick(stateOptionArizona, driver);
        HelperMethods.waitAndSendKeys(postalCodeValue, Config.POSTAL_CODE_VALUE_ARIZONA, driver);
//        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
//        HelperMethods.fluentWaitAndCheckVisible(findAddressButton, driver);
//        HelperMethods.waitAndClick(findAddressButton, driver);
//        Thread.sleep(2100);
//        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
//        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.scrollIntoViewForClick(saveAndContinue, driver);
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }
    public void directorsSaveAndContinue() throws InterruptedException {
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        HelperMethods.scrollIntoViewForClick(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }
    public void completeDirectorsAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
        Thread.sleep(2800);
//
//// If "removeDirector"  needed for these lines
//        if(HelperMethods.isElementDisplayed(removeDirector, driver))
//        {
//            HelperMethods.fluentWaitAndClick(removeDirector, driver);
//            Thread.sleep(1800);
//            HelperMethods.highLighterMethod(driver,removeDirectorYes);
//            Thread.sleep(1800);
//            HelperMethods.fluentWaitAndClick(removeDirectorYes, driver);
//        }
// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Thread.sleep(1800);
//        if(HelperMethods.isElementDisplayed(mustAddADirector, driver))
//        {
//            HelperMethods.highLighterMethod(driver, mustAddADirector);
//            Thread.sleep(7000);
//            HelperMethods.highLighterMethod(driver, fixedNumberOption);
//        }
        HelperMethods.fluentWaitAndClick(fixedNumberOption, driver);
        Thread.sleep(1800);
        HelperMethods.highLighterMethod(driver,fixedNumberOfDirectorsValue);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(fixedNumberOfDirectorsValue, "1", driver);
        HelperMethods.fluentWaitAndClick(addADirectorButton, driver);
        if (driver.getCurrentUrl().contains("appmybizaccount")) {
            HelperMethods.fluentWaitAndCheckVisible(addMeAsDirectorButton, driver);
            HelperMethods.fluentWaitAndClick(addMeAsDirectorButton, driver);
        } else {
            HelperMethods.fluentWaitAndCheckVisible(residentCanadaYesOption, driver);
            HelperMethods.fluentWaitAndClick(residentCanadaYesOption, driver);
            HelperMethods.fluentWaitAndClick(alsoAnIncorporatorYesOption, driver);
            HelperMethods.staleElementVisible(residentCanadaYesOption, driver);
            Thread.sleep(1800);
            HelperMethods.fluentLongWaitAndCheckVisible(alsoAnIncorporatorYesOption, driver);

            HelperMethods.fluentWaitAndCheckVisible(incorporateOntarioBusinessCorporationBanner, driver);
            HelperMethods.staleElementVisible(addressLookupField, driver);
            HelperMethods.staleElementVisible(doneButton, driver);
            HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
            HelperMethods.staleElementVisible(firstNameField, driver);
            HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
            HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
//            HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
            HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
            HelperMethods.staleElementVisible(findAddressButton, driver);
            Thread.sleep(1000);
            HelperMethods.staleElementClick(findAddressButton, driver);
            HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
            HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        }
        Thread.sleep(2500);
        HelperMethods.fluentWaitAndCheckVisible(residentCanadaYesOption, driver);
        HelperMethods.fluentWaitAndClick(residentCanadaYesOption, driver);
//        HelperMethods.fluentWaitAndClick(alsoAnIncorporatorYesOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(residentCanadaYesOption, driver);
//        HelperMethods.fluentLongWaitAndCheckVisible(alsoAnIncorporatorYesOption, driver);

        HelperMethods.fluentWaitAndCheckVisible(incorporateOntarioBusinessCorporationBanner, driver);
        HelperMethods.fluentWaitAndCheckVisible(addressLookupField, driver);
        if (HelperMethods.isElementDisplayed( streetNumberValue, driver))
        {
            Thread.sleep(1000);
            System.out.println("streetNumberValue is: " +streetNumberValue.getText());
            if (streetNumberValue.getText().equals(""))
            {
                HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
                HelperMethods.waitAndClick(findAddressButton, driver);
                HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
                HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
            }
        }
        if (HelperMethods.isElementDisplayed( addressLookupField, driver)) {
            HelperMethods.staleElementVisible(addressLookupField, driver);
            HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
            HelperMethods.staleElementVisible(findAddressButton, driver);
            Thread.sleep(1000);
            HelperMethods.staleElementClick(findAddressButton, driver);
            Thread.sleep(1000);
            HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
            HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
            HelperMethods.waitAndSendKeys(streetNumberRegister, Config.STREET_NUMBER_VALUE_DR, driver);
        }
        HelperMethods.staleElementClick(doneButton, driver);
        Thread.sleep(1900);
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        HelperMethods.scrollIntoViewForClick(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }
    public void multipleDirectorsAndSave(int numberOfDirectors) throws InterruptedException {
        HelperMethods.fluentLongWaitAndCheckVisible(fixedNumberOption, driver);
        HelperMethods.fluentWaitAndClick(fixedNumberOption, driver);
        HelperMethods.waitAndSendKeys(fixedNumberOfDirectorsValue, Integer.toString(numberOfDirectors), driver);
//        HelperMethods.fluentWaitAndClick(addADirectorButton, driver);

//        HelperMethods.fluentWaitAndCheckVisible(addMeAsDirectorButton, driver);
//        HelperMethods.fluentWaitAndClick(addMeAsDirectorButton, driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(alsoAnIncorporatorYesOption, driver);
//        HelperMethods.fluentWaitAndClick(alsoAnIncorporatorYesOption, driver);
////        HelperMethods.fluentWaitAndCheckVisible(addMeAsDirectorButton, driver);
//        HelperMethods.fluentLongWaitAndCheckVisible(alsoAnIncorporatorYesOption, driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(usAddressOption, driver);
//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
//        HelperMethods.staleElementVisible(saveAndContinue, driver);
//        HelperMethods.staleElementClick(doneButtonNotForProfit, driver);

        for (int i = 1; i < numberOfDirectors+1; i++) {
            Thread.sleep(10200);
            HelperMethods.fluentLongWaitAndCheckVisible(addADirectorButton, driver);
            Thread.sleep(15200);
            HelperMethods.fluentWaitAndClick(addADirectorButton, driver);
//            HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
//            HelperMethods.staleElementClick(addADirectorButton, driver);
            Thread.sleep(5200);
            HelperMethods.fluentLongWaitAndCheckVisible(firstNameField, driver);
            HelperMethods.waitAndSendKeys(firstNameField, Config.DIRECTOR_FIRST_NAME + i, driver);
            HelperMethods.waitAndSendKeys(lastNameField, Config.DIRECTOR_LAST_NAME + i, driver);
            HelperMethods.waitAndClick(residentCanadaYesOption, driver);
            HelperMethods.waitAndClick(alsoAnIncorporatorYesOption, driver);

            HelperMethods.fluentLongWaitAndCheckVisible(enterAddressManuallyLink, driver);

            Thread.sleep(15000);
            HelperMethods.staleElementClick(enterAddressManuallyLink, driver);
            Thread.sleep(4200);
            HelperMethods.fluentLongWaitAndCheckVisible(streetNumberValue, driver);
            HelperMethods.waitAndSendKeys(streetNumberValue, Integer.toString(i), driver);
            HelperMethods.waitAndSendKeys(streetNameValue, Config.STREET_NAME_VALUE, driver);
            HelperMethods.waitAndSendKeys(cityValue, Config.CITY_VALUE, driver);
            HelperMethods.waitAndClick(provinceDropdownAddDirector, driver);
            HelperMethods.waitAndSendKeys(jurisdictionSearchArea, Config.PROVINCE_ONTARIO, driver);
            HelperMethods.waitAndClick(jurisdictionSearchResultCanada, driver);

            HelperMethods.fluentLongWaitAndCheckVisible(postalCodeValue, driver);
            HelperMethods.waitAndSendKeys(postalCodeValue, Config.POSTAL_CODE_VALUE, driver);
            HelperMethods.staleElementClick(doneButtonNotForProfit, driver);
            System.out.println("Director - " + i + ":" + Config.DIRECTOR_FIRST_NAME + i +"; " + Config.DIRECTOR_LAST_NAME + i +" has been added");
            Reporter.log("Director - " + i + ":" + Config.DIRECTOR_FIRST_NAME + i +"; " + Config.DIRECTOR_LAST_NAME + i +" has been added");

        }

        Thread.sleep(10200);
        HelperMethods.fluentLongWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void completeDirectorsAndSaveNotForProfitCorporation() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(fixedNumberOption, driver);
        HelperMethods.fluentWaitAndClick(fixedNumberOption, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(fixedNumberOfDirectorsValue, driver);
        HelperMethods.highLighterMethod(driver, fixedNumberOfDirectorsValue);
        HelperMethods.waitAndSendKeys(fixedNumberOfDirectorsValue, "3", driver);
//        HelperMethods.fluentWaitAndClick(addADirectorButton, driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(addMeAsDirectorButton, driver);
//        HelperMethods.fluentWaitAndClick(addMeAsDirectorButton, driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(alsoAnIncorporatorYesOption, driver);
//        HelperMethods.fluentWaitAndClick(alsoAnIncorporatorYesOption, driver);
////        HelperMethods.fluentWaitAndCheckVisible(addMeAsDirectorButton, driver);
//        HelperMethods.fluentLongWaitAndCheckVisible(alsoAnIncorporatorYesOption, driver);

//        HelperMethods.fluentWaitAndCheckVisible(usAddressOption, driver);
// +++++++++++++++
        Thread.sleep(1000);
        for (int i = 0; i < 3; i++) {

            HelperMethods.staleElementClick(addADirectorButton, driver);
            HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
//            if (HelperMethods.verifyElementGrey(addADirectorButton) !=true) {
//                HelperMethods.fluentWaitAndClick(addADirectorButton, driver);
//            }
//            if (HelperMethods.verifyElementGrey(addADirectorButton) !=true) {
//                HelperMethods.fluentWaitAndClick(addADirectorButton, driver);
//            }

            HelperMethods.staleElementVisible(firstNameField, driver);
            HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE +i, driver);
            HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE +i, driver);
            HelperMethods.fluentWaitAndCheckVisible(alsoAnIncorporatorYesOption, driver);
            HelperMethods.fluentWaitAndClick(alsoAnIncorporatorYesOption, driver);
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
            HelperMethods.staleElementVisible(driver.findElement(By.xpath("//span[text()='Done']")), driver);
            HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Done']")), driver);
        }
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void completeCourtOrderBusinessCorp() throws InterruptedException {
//        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
        driver.switchTo().frame(ShareClassDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Classes of Shares: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareRights);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Rights, Privileges, Restrictions and Conditions: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareTransferDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Restrictions on Share Transfers: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareBusinessDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Restrictions on Business or Powers: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(OtherProvisionDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Other provisions: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent
// +++++++++++++++++
//        HelperMethods.fluentWaitAndCheckVisible(courtOrderHeading, driver);
//        HelperMethods.fluentWaitAndCheckVisible(descriptionOfClassesTextArea, driver);
//        HelperMethods.waitAndSendKeys(descriptionOfClassesTextArea, Config.DESCRIPTION_OF_CLASSES_TEXT, driver);
//        HelperMethods.waitAndSendKeys(rightsPrivilegesTextArea, Config.DESCRIPTION_OF_RIGHTS_TEXT, driver);
//        HelperMethods.waitAndSendKeys(restrictionsOnShareTextArea, Config.DESCRIPTION_OF_RESTRICTIONS_ON_TRANSFER_TEXT, driver);
//        HelperMethods.waitAndSendKeys(restrictionsOnBusinessTextArea, Config.DESCRIPTION_OF_RESTRICTIONS_ON_BUSINESS_TEXT, driver);
//        HelperMethods.waitAndSendKeys(otherProvisionsTextArea, Config.DESCRIPTION_OF_OTHER_PROVISIONS_TEXT, driver);
        HelperMethods.fluentWaitAndCheckVisible(confirmationCheckBox, driver);
        HelperMethods.staleElementClick(confirmationCheckBox, driver);
        HelperMethods.staleElementClick(requiredStatementCheckBox, driver);
        HelperMethods.fluentWaitAndCheckVisible(JurisdictionUploadButton, driver);

        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
        HelperMethods.staleElementClick(JurisdictionUploadButton, driver);

        driver.findElement(By.cssSelector("input[type=file]"))
                .sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");

        HelperMethods.staleElementVisible(submitButton, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(submitButton, driver);
    }
    public void fileArticlesOfReorganizationCourtOrderBusinessCorp() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(courtOrderHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(confirmationCheckBox, driver);
        HelperMethods.staleElementClick(confirmationCheckBox, driver);
//        HelperMethods.staleElementClick(requiredStatementCheckBox, driver);
        HelperMethods.fluentWaitAndCheckVisible(JurisdictionUploadButton, driver);

        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
        HelperMethods.staleElementClick(JurisdictionUploadButton, driver);

        driver.findElement(By.cssSelector("input[type=file]"))
                .sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");

        HelperMethods.staleElementVisible(submitButton, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(submitButton, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(submitButton, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(submitButton, driver);
        HelperMethods.staleElementClick(submitButton, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(submitButton, driver);
//        HelperMethods.fluentWaitAndCheckVisible(confirmationCheckBox, driver);
        HelperMethods.staleElementClick(confirmationCheckBox, driver);
        HelperMethods.staleElementClick(submitButton, driver);
    }
    public void completeSharesProvisionsAndSaveOntarioBusinessCorp() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
        driver.switchTo().frame(ShareClassDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Classes of Shares: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareRights);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Rights, Privileges, Restrictions and Conditions: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareTransferDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Restrictions on Share Transfers: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareBusinessDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Restrictions on Business or Powers: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(OtherProvisionDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Other provisions: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent
// +++++++
//        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
//        HelperMethods.fluentWaitAndCheckVisible(descriptionOfClassesTextArea, driver);
//        HelperMethods.waitAndSendKeys(descriptionOfClassesTextArea, Config.DESCRIPTION_OF_CLASSES_TEXT, driver);
//        HelperMethods.waitAndSendKeys(rightsPrivilegesTextArea, Config.DESCRIPTION_OF_RIGHTS_TEXT, driver);
//        HelperMethods.waitAndSendKeys(restrictionsOnShareTextArea, Config.DESCRIPTION_OF_RESTRICTIONS_ON_TRANSFER_TEXT, driver);
//        HelperMethods.waitAndSendKeys(restrictionsOnBusinessTextArea, Config.DESCRIPTION_OF_RESTRICTIONS_ON_BUSINESS_TEXT, driver);
//        HelperMethods.waitAndSendKeys(otherProvisionsTextArea, Config.DESCRIPTION_OF_OTHER_PROVISIONS_TEXT, driver);
        HelperMethods.fluentWaitAndCheckVisible(confirmationCheckBox, driver);
        HelperMethods.staleElementClick(confirmationCheckBox, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(submitButton, driver);
        HelperMethods.staleElementClick(submitButton, driver);
    }

    public void completefileArticlesOfAmendmentOfIncorporation() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfAmendment, driver);
        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisions, driver);
        HelperMethods.staleElementClick(sharesAndProvisions, driver);

        driver.switchTo().frame(ShareClassDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Classes of Shares: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareRights);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Changes to Rights, Privileges, Restrictions and Conditions: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareTransferDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Changes to Restrictions on Share Transfers: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareBusinessDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Changes to Restrictions on Business or Powers: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(OtherProvisionDesc);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Changes to Other Provisions: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver, informationOnFileSaveAndContinue);
        HelperMethods.fluentWaitAndCheckVisible(informationOnFileSaveAndContinue, driver);
        HelperMethods.waitAndClick(informationOnFileSaveAndContinue, driver);

//        HelperMethods.fluentWaitAndCheckVisible(descriptionOfClassesTextArea, driver);
//        HelperMethods.waitAndSendKeys(descriptionOfClassesTextArea, Config.DESCRIPTION_OF_CLASSES_TEXT, driver);
//        HelperMethods.waitAndSendKeys(rightsPrivilegesTextArea, Config.DESCRIPTION_OF_RIGHTS_TEXT, driver);
//        HelperMethods.waitAndSendKeys(restrictionsOnShareTextArea, Config.DESCRIPTION_OF_RESTRICTIONS_ON_TRANSFER_TEXT, driver);
//        HelperMethods.waitAndSendKeys(restrictionsOnBusinessTextArea, Config.DESCRIPTION_OF_RESTRICTIONS_ON_BUSINESS_TEXT, driver);
//        HelperMethods.waitAndSendKeys(otherProvisionsTextArea, Config.DESCRIPTION_OF_OTHER_PROVISIONS_TEXT, driver);
//        HelperMethods.fluentWaitAndCheckVisible(confirmationCheckBox, driver);
//        HelperMethods.staleElementClick(confirmationCheckBox, driver);
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver, dateAuthorizingAmendment);
//        HelperMethods.waitAndSendKeys(dateAuthorizingAmendment,"July 10, 2022", driver);
        HelperMethods.waitAndSendKeys(dateAuthorizingAmendment,HelperMethods.getPreviousDate(0) ,driver);
        Thread.sleep(100);
        HelperMethods.highLighterMethod(driver, informationOnFileSaveAndContinue);
        HelperMethods.fluentWaitAndCheckVisible(informationOnFileSaveAndContinue, driver);
        HelperMethods.waitAndClick(informationOnFileSaveAndContinue, driver);
        HelperMethods.fluentWaitAndCheckVisible(confirmationCheckBox, driver);
        HelperMethods.staleElementClick(confirmationCheckBox, driver);
        HelperMethods.fluentWaitAndCheckVisible(submitButton, driver);
        HelperMethods.staleElementClick(submitButton, driver);
    }
    public void fileArticlesOfAmendmentCorporationName() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfAmendment, driver);

        HelperMethods.staleElementClick(purposesAndProvisions, driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//label[text()='No']")), driver);
// +++++++++
// Switch to the frame using the frame title
        driver.switchTo().frame(Purposes);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "The purposes of the corporation are: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);

        //    driver.findElement(By.xpath("/html/body")).sendKeys("The purposes of the corporation are: " + Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime());
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent
        driver.switchTo().frame(SpecialProvisions);
//        driver.findElement(By.xpath("/html/body")).sendKeys("SoftwareTestingHelp.com ******");

        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "If the corporation will have additional special provisions, enter them in the space below: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        // Print the frame source code
        //       System.out.println("Frame Source" +driver.getPageSource());

        // Switch back to main web page
        driver.switchTo().defaultContent();
        HelperMethods.fluentWaitAndCheckVisible(informationOnFileSaveAndContinue, driver);
        HelperMethods.staleElementClick(informationOnFileSaveAndContinue, driver);


        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[@class='appInputContainer']//input")));
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//div[@class='appInputContainer']//input")), HelperMethods.getPreviousDate(0), driver);
        HelperMethods.fluentWaitAndCheckVisible(informationOnFileSaveAndContinue, driver);
        HelperMethods.staleElementClick(informationOnFileSaveAndContinue, driver);
// ++++++++++

//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//div[@class='appAttrLabelBox']/following-sibling::textarea")), Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//div[@class='appFieldHelp']/following-sibling::textarea[1]")), Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        HelperMethods.fluentWaitAndCheckVisible(confirmationCheckBox, driver);
        HelperMethods.staleElementClick(confirmationCheckBox, driver);
        Thread.sleep(1000);
//        HelperMethods.highLighterMethod(driver, dateAuthorizingAmendment);
//        HelperMethods.waitAndSendKeys(dateAuthorizingAmendment,"July 10, 2022", driver);
//        HelperMethods.waitAndSendKeys(dateAuthorizingAmendment,HelperMethods.getPreviousDate(0) ,driver);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonExtraProvincial, driver);
        HelperMethods.staleElementClick(submitButtonExtraProvincial, driver);
    }
    public void completeFileArticlesOfFileDraftPlanForArrangement() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfArrangement, driver);
        HelperMethods.fluentWaitAndCheckVisible(SummaryOfChangesTextArea, driver);
        HelperMethods.waitAndSendKeys(SummaryOfChangesTextArea, "Summary of Changes - " + HelperMethods.getCurrentDate(), driver);

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
        HelperMethods.highLighterMethod(driver, uploadButtonFirst);
        HelperMethods.staleElementClick(uploadButtonFirst, driver);
        System.out.println("user dir: " + System.getProperty("user.dir"));
        driver.findElement(By.xpath("(//input[@type='file'])[2]"))
                //.sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");


        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(uploadButtonSecond, driver);
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
        HelperMethods.staleElementClick(uploadButtonSecond, driver);
        driver.findElement(By.cssSelector("input[type=file]"))
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1000);

        HelperMethods.fluentWaitAndCheckVisible(confirmationCheckBox, driver);
        HelperMethods.staleElementClick(confirmationCheckBox, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(submitButton, driver);
        HelperMethods.staleElementClick(submitButton, driver);

        //    HelperMethods.isObjectPresentByXpath(driver, "//span[text()='Ok']");
        if(HelperMethods.isObjectPresentByXpath(driver, "//*[@id=\"sentForReviewDialogOkButton\"]/span") >0) {
            HelperMethods.staleElementVisible(sentForReviewDialogOkButton, driver);
            HelperMethods.fluentLongWaitAndClick(sentForReviewDialogOkButton, driver);
        }
    }
    public void completeDraftPlanOfArrangementNotforProfitCorporation() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.tagName("textarea")), driver);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.tagName("textarea")), driver);
        HelperMethods.waitAndSendKeys(driver.findElement(By.tagName("textarea")), "Summary of Changes - " + HelperMethods.getCurrentDate(), driver);

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
        HelperMethods.highLighterMethod(driver, uploadButtonFirst);
        HelperMethods.staleElementClick(uploadButtonFirst, driver);
        System.out.println("user dir: " + System.getProperty("user.dir"));
        driver.findElement(By.xpath("(//input[@type='file'])[2]"))
                //.sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");


        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(uploadButtonSecond, driver);
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
        HelperMethods.staleElementClick(uploadButtonSecond, driver);
        driver.findElement(By.cssSelector("input[type=file]"))
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1000);

        HelperMethods.fluentWaitAndCheckVisible(confirmationCheckBox, driver);
        HelperMethods.staleElementClick(confirmationCheckBox, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Submit']")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Submit']")), driver);

        //    HelperMethods.isObjectPresentByXpath(driver, "//span[text()='Ok']");
//        if(HelperMethods.isObjectPresentByXpath(driver, "//*[@id=\"sentForReviewDialogOkButton\"]/span") >0) {
//            HelperMethods.staleElementVisible(sentForReviewDialogOkButton, driver);
//            HelperMethods.fluentLongWaitAndClick(sentForReviewDialogOkButton, driver);
//        }
    }
    public void completeFinalPlanOfArrangementNotforProfitCorporation() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//label[text()='No']")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//label[text()='No']")), driver);
        Thread.sleep(1200);
        HelperMethods.verifyElementEnabled(driver.findElement(By.xpath("//span[text()='Ok']")), driver);
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//span[text()='Ok']")));
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Ok']")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Ok']")), driver);
        Thread.sleep(2200);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.tagName("textarea")), driver);
        HelperMethods.waitAndSendKeys(driver.findElement(By.tagName("textarea")), "Summary of Changes - " + HelperMethods.getCurrentDate(), driver);
        Thread.sleep(1200);
        HelperMethods.highLighterMethod(driver, dateAuthorizingAmendment);
        HelperMethods.waitAndSendKeys(dateAuthorizingAmendment,HelperMethods.getPreviousDate(0) ,driver);
        Thread.sleep(1200);

        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
//        Thread.sleep(1200);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", uploadButtonFirst);

// trigger the upload
//        driver.findElement(By.xpath("//button[contains(@class,'appDocumentUpload-')]")).click();
        HelperMethods.highLighterMethod(driver, uploadButtonFirst);
        HelperMethods.staleElementClick(uploadButtonFirst, driver);
        System.out.println("user dir: " + System.getProperty("user.dir"));
        driver.findElement(By.xpath("(//input[@type='file'])[2]"))
                //.sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");


        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(uploadButtonSecond, driver);
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
        HelperMethods.staleElementClick(uploadButtonSecond, driver);
        driver.findElement(By.cssSelector("input[type=file]"))
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1000);

        HelperMethods.fluentWaitAndCheckVisible(confirmationCheckBox, driver);
        HelperMethods.staleElementClick(confirmationCheckBox, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Submit']")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Submit']")), driver);

    }
public void completefileArticlesOfAuthorizationContinueOutOfBusiness() throws InterruptedException {
    HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfAuthorizationContinueOutOfBusiness, driver);
    HelperMethods.staleElementClick(fileArticlesOfAuthorizationContinueOutOfBusiness, driver);
    HelperMethods.fluentWaitAndCheckVisible(confirmationCheckBox, driver);
    Thread.sleep(2000);
    HelperMethods.staleElementClick(confirmationCheckBox, driver);
    Thread.sleep(1000);
    HelperMethods.selectOptionFromDropdownselectByIndex(1, selectJurisdiction, driver);
    HelperMethods.staleElementClick(indicateCorporationConfirms, driver);
    HelperMethods.staleElementClick(notDefaultFilingNotices, driver);
    HelperMethods.staleElementClick(securitiesToPublic, driver);
    Thread.sleep(2000);
    HelperMethods.fluentWaitAndCheckVisible(submitButton, driver);
    HelperMethods.staleElementClick(submitButton, driver);
}

    public void completeApplicationForAuthorizationToContinueOutOfNFPCA() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(anotherCanadianJurisdiction, driver);
        HelperMethods.staleElementClick(anotherCanadianJurisdiction, driver);
        HelperMethods.selectOptionFromDropdownselectByIndex(1, jurisdictionCorporationApplyingToContinue, driver);

        HelperMethods.fluentWaitAndCheckVisible(reviewCertification, driver);
        Thread.sleep(2000);
        HelperMethods.staleElementClick(reviewCertification, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementClick(compliedWithSubSectionCheckBox, driver);
        Thread.sleep(1000);

        HelperMethods.staleElementClick(driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::label)[3]")), driver);

        HelperMethods.staleElementClick(driver.findElement(By.cssSelector("form#viewInstanceForm>div:nth-of-type(2)>div>div>div>div:nth-of-type(3)>div:nth-of-type(6)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div:nth-of-type(2)>div>label")), driver);

        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonExtraProvincial, driver);
        HelperMethods.staleElementClick(submitButtonExtraProvincial, driver);
    }

    public void completeFileArticlesOfContinuance() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfAuthorizationContinueOutOfBusiness, driver);
        HelperMethods.staleElementClick(fileArticlesOfAuthorizationContinueOutOfBusiness, driver);
        HelperMethods.fluentWaitAndCheckVisible(confirmationCheckBox, driver);
        Thread.sleep(2000);
        HelperMethods.staleElementClick(confirmationCheckBox, driver);
        Thread.sleep(1000);
        HelperMethods.selectOptionFromDropdownselectByIndex(1, selectJurisdiction, driver);
        HelperMethods.staleElementClick(indicateCorporationConfirms, driver);
        HelperMethods.staleElementClick(notDefaultFilingNotices, driver);
        HelperMethods.staleElementClick(securitiesToPublic, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(Submit, driver);
        HelperMethods.staleElementClick(Submit, driver);
    }


    public void completeFileArticlesDissolveCorporation() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfDissolution, driver);
//        HelperMethods.fluentWaitAndCheckVisible(descriptionOfClassesTextArea, driver);
//        HelperMethods.waitAndSendKeys(descriptionOfClassesTextArea, Config.DESCRIPTION_OF_CLASSES_TEXT, driver);
//        HelperMethods.waitAndSendKeys(rightsPrivilegesTextArea, Config.DESCRIPTION_OF_RIGHTS_TEXT, driver);
//        HelperMethods.waitAndSendKeys(restrictionsOnShareTextArea, Config.DESCRIPTION_OF_RESTRICTIONS_ON_TRANSFER_TEXT, driver);
//        HelperMethods.waitAndSendKeys(restrictionsOnBusinessTextArea, Config.DESCRIPTION_OF_RESTRICTIONS_ON_BUSINESS_TEXT, driver);
//        HelperMethods.waitAndSendKeys(otherProvisionsTextArea, Config.DESCRIPTION_OF_OTHER_PROVISIONS_TEXT, driver);
        HelperMethods.fluentWaitAndCheckVisible(typeOfVoluntaryDissolution, driver);
        HelperMethods.staleElementClick(typeOfVoluntaryDissolution, driver);

        HelperMethods.staleElementClick(authorizedUnderClause237, driver);
        HelperMethods.staleElementClick(hasNotCommencedBusiness, driver);
        HelperMethods.staleElementClick(sharesOfcorporation, driver);
        HelperMethods.staleElementClick(corporationHasNoDebts, driver);


        HelperMethods.fluentWaitAndCheckVisible(requestedDateDissolution, driver);
        HelperMethods.staleElementClick(requestedDateDissolution, driver);

        HelperMethods.staleElementClick(noPropertyTodistribute, driver);

        HelperMethods.staleElementClick(registeredOwnerOfLand, driver);
        HelperMethods.staleElementClick(noProceedingsPending, driver);
        HelperMethods.staleElementClick(applicationMOF, driver);
        HelperMethods.staleElementClick(AllNoticesReturnsRequired, driver);


        Thread.sleep(1000);
//        HelperMethods.highLighterMethod(driver, dateAuthorizingAmendment);
//        HelperMethods.waitAndSendKeys(dateAuthorizingAmendment,"July 10, 2022", driver);
//        HelperMethods.waitAndSendKeys(dateAuthorizingAmendment,HelperMethods.getPreviousDate(0) ,driver);

        HelperMethods.fluentWaitAndCheckVisible(confirmationCheckBox, driver);
        HelperMethods.staleElementClick(confirmationCheckBox, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(submitButton, driver);
        HelperMethods.staleElementClick(submitButton, driver);
    }

    public void completeCourtOrderedWindingUpDissolutionOrder() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(courtOrderedWindingUpDissolutionOrders, driver);
        HelperMethods.waitAndSendKeys(dateAuthorizingAmendment,HelperMethods.getPreviousDate(0) ,driver);
        HelperMethods.fluentWaitAndCheckVisible(JurisdictionUploadButton, driver);

        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");

        driver.findElement(By.xpath("//button[contains(@id,'_upload_button')]"))
                .click();

        driver.findElement(By.cssSelector("input[type=file]"))
//                .sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");
//                .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");

        HelperMethods.fluentWaitAndCheckVisible(confirmationCheckBox, driver);
        HelperMethods.staleElementClick(confirmationCheckBox, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(submitButton, driver);
        HelperMethods.staleElementClick(submitButton, driver);
    }
    public void completeSharesProvisionsSampleRichTextAndSave() throws InterruptedException {

            HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
            Thread.sleep(1200);
            HelperMethods.staleElementClick(sharesAndProvisionsSetOutMyOwnTextOption, driver);
            HelperMethods.staleElementVisible(sharesAndProvisionsHeading, driver);
            Thread.sleep(2200);
        Thread.sleep(10200);

        // ReadSampleRichText using VBS
        try {
            Runtime.getRuntime().exec("wscript " + System.getProperty("user.dir")+ "\\ReadSampleRichText.vbs");
            System.out.println("'wscript " + System.getProperty("user.dir")+ "\\ReadSampleRichText.vbs' - is executed to Entrust login Window");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(35200);
        driver.switchTo().frame(ShareClassDesc);
        try {
            String data = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
            //   System.out.println("pasting....." + data);
            //  driver.findElement(By.xpath("/html/body")).sendKeys(data);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body")).sendKeys(Keys.CONTROL + "v");
        Thread.sleep(15200);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Classes of Shares: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareRights);
        driver.findElement(By.xpath("/html/body")).sendKeys(Keys.CONTROL + "v");
        Thread.sleep(15200);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Rights, Privileges, Restrictions and Conditions: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareTransferDesc);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Restrictions on Share Transfers: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.findElement(By.xpath("/html/body")).sendKeys(Keys.CONTROL + "v");
        Thread.sleep(15200);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(ShareBusinessDesc);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Restrictions on Business or Powers: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.findElement(By.xpath("/html/body")).sendKeys(Keys.CONTROL + "v");
        Thread.sleep(15200);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(OtherProvisionDesc);
        driver.findElement(By.xpath("/html/body")).sendKeys(Keys.CONTROL + "v");
        Thread.sleep(15200);
        //        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Other provisions: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

// +++++
//        Thread.sleep(5200);
//        HelperMethods.staleElementClick(sharesAndProvisionsSetOutMyOwnTextOption, driver);
//        driver.switchTo().frame(0);
//        WebElement el  =  driver.switchTo().activeElement();
//        new Actions(driver).moveToElement(el).perform();
//       // driver.findElement(By.xpath("/html/body")).click();
//  //      driver.findElement(By.xpath("/html/body")).sendKeys("paste heer...");
//        Thread.sleep(10200);
//
//        // ReadSampleRichText using VBS
//        try {
//            Runtime.getRuntime().exec("wscript " + System.getProperty("user.dir")+ "\\ReadSampleRichText.vbs");
//            System.out.println("'wscript " + System.getProperty("user.dir")+ "\\ReadSampleRichText.vbs' - is executed to Entrust login Window");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Thread.sleep(35200);
////        String txt = HelperMethods.getClipBoard();
//
////
//////        driver.findElement(By.xpath("/html/body")).sendKeys(HelperMethods.getClipBoard());
//////        driver.findElement(By.xpath("/html/body")).sendKeys(txt);
////        try {
////            HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("/html/body")));
////            driver.findElement(By.xpath("/html/body")).click();
////            driver.findElement(By.xpath("/html/body")).sendKeys("paste here...");
////            driver.findElement(By.xpath("/html/body")).sendKeys(HelperMethods.getClipBoard());
////
////            driver.findElement(By.xpath("/html/body")).sendKeys((String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
////        } catch (UnsupportedFlavorException e) {
////            e.printStackTrace();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        driver.findElement(By.xpath("/html/body")).sendKeys(HelperMethods.getClipBoard());
//
//        try {
//            String data = (String) Toolkit.getDefaultToolkit()
//                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
//         //   System.out.println("pasting....." + data);
//          //  driver.findElement(By.xpath("/html/body")).sendKeys(data);
//        } catch (UnsupportedFlavorException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        driver.findElement(By.xpath("/html/body")).sendKeys(Keys.CONTROL + "v");
//        Thread.sleep(15200);
//        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent
//// +++++++++++++++++++++++++
//        Thread.sleep(1200);
//        try {
//            HelperMethods.robotSendTAB();
//            HelperMethods.robotSendPaste();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//        Thread.sleep(1200);
//        try {
//            HelperMethods.robotSendTAB();
//            HelperMethods.robotSendTAB();
//            HelperMethods.robotSendPaste();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//        Thread.sleep(1200);
//        try {
//            HelperMethods.robotSendTAB();
//            HelperMethods.robotSendPaste();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//
//        Thread.sleep(1200);
//        try {
//            HelperMethods.robotSendTAB();
//                HelperMethods.robotSendPaste();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//        Thread.sleep(45200);
//        try {
//            HelperMethods.robotSendTAB();
//            Thread.sleep(1200);
//            HelperMethods.robotSendENTER();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
             HelperMethods.staleElementVisible(SaveAndContinueButton, driver);
            HelperMethods.staleElementClick(SaveAndContinueButton, driver);
      //  }
    }
    public void completeSharesProvisionsAndSave() throws InterruptedException {
        if (driver.getCurrentUrl().contains("appmybizaccount")) {
            HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
            driver.switchTo().frame(ShareClassDesc);
            HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Classes of Shares: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
            driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

            driver.switchTo().frame(ShareRights);
            HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Rights, Privileges, Restrictions and Conditions: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
            driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

            driver.switchTo().frame(ShareTransferDesc);
            HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Restrictions on Share Transfers: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
            driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

            driver.switchTo().frame(ShareBusinessDesc);
            HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Restrictions on Business or Powers: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
            driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

            driver.switchTo().frame(OtherProvisionDesc);
            HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Other provisions: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
            driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent


//            HelperMethods.fluentWaitAndCheckVisible(descriptionOfClassesTextArea, driver);
//            HelperMethods.waitAndSendKeys(descriptionOfClassesTextArea, Config.DESCRIPTION_OF_CLASSES_TEXT, driver);
//            HelperMethods.waitAndSendKeys(rightsPrivilegesTextArea, Config.DESCRIPTION_OF_RIGHTS_TEXT, driver);
//            HelperMethods.waitAndSendKeys(restrictionsOnShareTextArea, Config.DESCRIPTION_OF_RESTRICTIONS_ON_TRANSFER_TEXT, driver);
//            HelperMethods.waitAndSendKeys(restrictionsOnBusinessTextArea, Config.DESCRIPTION_OF_RESTRICTIONS_ON_BUSINESS_TEXT, driver);
//            HelperMethods.waitAndSendKeys(otherProvisionsTextArea, Config.DESCRIPTION_OF_OTHER_PROVISIONS_TEXT, driver);
//        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsOtherProvisionsHeading, driver);
//        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
            HelperMethods.staleElementClick(saveAndContinue, driver);
        } else {
            HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
            Thread.sleep(1200);
            HelperMethods.staleElementClick(sharesAndProvisionsPreDefinedTextOption, driver);
            HelperMethods.staleElementVisible(sharesAndProvisionsHeading, driver);
            Thread.sleep(2200);
            HelperMethods.staleElementVisible(saveAndContinue, driver);
            HelperMethods.staleElementClick(saveAndContinue, driver);
        }
    }
    public void completeSharesProvisionsNoiFrameAndSave() throws InterruptedException {
        if (driver.getCurrentUrl().contains("appmybizaccount")) {
            HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
//            driver.switchTo().frame(ShareClassDesc);
//            HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Description of Classes of Shares: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
//            driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent
//
//            driver.switchTo().frame(ShareRights);
//            HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Rights, Privileges, Restrictions and Conditions: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
//            driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent
//
//            driver.switchTo().frame(ShareTransferDesc);
//            HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Restrictions on Share Transfers: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
//            driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent
//
//            driver.switchTo().frame(ShareBusinessDesc);
//            HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Restrictions on Business or Powers: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
//            driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent
//
//            driver.switchTo().frame(OtherProvisionDesc);
//            HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "Other provisions: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
//            driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent


            HelperMethods.fluentWaitAndCheckVisible(descriptionOfClassesTextArea, driver);
            HelperMethods.waitAndSendKeys(descriptionOfClassesTextArea, Config.DESCRIPTION_OF_CLASSES_TEXT, driver);
            HelperMethods.waitAndSendKeys(rightsPrivilegesTextArea, Config.DESCRIPTION_OF_RIGHTS_TEXT, driver);
            HelperMethods.waitAndSendKeys(restrictionsOnShareTextArea, Config.DESCRIPTION_OF_RESTRICTIONS_ON_TRANSFER_TEXT, driver);
            HelperMethods.waitAndSendKeys(restrictionsOnBusinessTextArea, Config.DESCRIPTION_OF_RESTRICTIONS_ON_BUSINESS_TEXT, driver);
            HelperMethods.waitAndSendKeys(otherProvisionsTextArea, Config.DESCRIPTION_OF_OTHER_PROVISIONS_TEXT, driver);
//        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsOtherProvisionsHeading, driver);
//        HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
            HelperMethods.staleElementClick(saveAndContinue, driver);
        } else {
            HelperMethods.fluentWaitAndCheckVisible(sharesAndProvisionsHeading, driver);
            Thread.sleep(1200);
            HelperMethods.staleElementClick(sharesAndProvisionsPreDefinedTextOption, driver);
            HelperMethods.staleElementVisible(sharesAndProvisionsHeading, driver);
            Thread.sleep(2200);
            HelperMethods.staleElementVisible(saveAndContinue, driver);
            HelperMethods.staleElementClick(saveAndContinue, driver);
        }
    }

    public void completeRequiredStatementsAndSave() {
        if (pageTitleArticle.getText().contains(Config.APPLICATION_FOR_EXTRA_PROVINCIAL_LICENCE_FOR_FOREIGN_CORP_HEADER)) {
            HelperMethods.fluentWaitAndCheckVisible(requiredStatementsHeading, driver);
            HelperMethods.fluentWaitAndCheckVisible(continueUnderBusinessCorporationActCheckBox, driver);
            HelperMethods.waitAndClick(continueUnderBusinessCorporationActCheckBox, driver);
            HelperMethods.waitAndClick(dateIcon, driver);
            HelperMethods.waitAndClick(requestDateForIncorporationTodaysDate, driver);
        } else if (pageTitleArticle.getText().contains(Config.FILE_ARTICLE_OF_CONTINUANCE_BUSINESS_CORP_HEADER)) {
            HelperMethods.fluentWaitAndCheckVisible(requiredStatementsHeading, driver);
            HelperMethods.fluentWaitAndCheckVisible(continueUnderBusinessCorporationActCheckBox, driver);
            HelperMethods.waitAndClick(continueUnderBusinessCorporationActCheckBox, driver);
            HelperMethods.waitAndClick(compliedWithSubSectionCheckBox, driver);
            HelperMethods.waitAndClick(authorizationDateCheckBox, driver);
            HelperMethods.waitAndClick(requiredStatementDateIcon, driver);
            HelperMethods.waitAndClick(requestDateForIncorporationTodaysDate, driver);
        }
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void completeRequiredStatementsAndSaveForeignCorp() throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(requiredStatementsHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(continueUnderBusinessCorporationActCheckBox, driver);
        HelperMethods.waitAndClick(continueUnderBusinessCorporationActCheckBox, driver);
        Thread.sleep(1000);
        HelperMethods.waitAndClick(foreignDateSelectionIcon, driver);
        HelperMethods.waitAndClick(requestDateForIncorporationTodaysDate, driver);
        HelperMethods.waitAndClick(saveAndContinue, driver);
    }
    public void requiredStatements() throws InterruptedException {
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Required Statements']")), driver);
//        Thread.sleep(3000);
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[text()='Required Statements']")), driver);
        HelperMethods.fluentWaitAndCheckVisible(requiredStatementsHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(reviewCertification, driver);
        HelperMethods.waitAndClick(reviewCertification, driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("//label[text()='The corporation has complied with subsection 114(2) or 115(4), as applicable, of the Not-for-Profit Corporations Act, 2010.']")),driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("//label[text()='The continuation of the corporation under the laws of the Province of Ontario has been properly authorized under the laws of the jurisdiction currently governing the corporation, on the following date:']")),driver);
        HelperMethods.waitAndClick(jurisdictionDateSelectionIcon, driver);
        Thread.sleep(2000);
        HelperMethods.waitAndClick(jurisdictionTodaysDate, driver);
        Thread.sleep(3000);
        HelperMethods.waitAndClick(saveAndContinue, driver);
    }
    public void completeRequiredStatementsFileArticlesOfRevival() throws InterruptedException {
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Required Statements']")), driver);
//        Thread.sleep(3000);
//        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[text()='Required Statements']")), driver);
        HelperMethods.fluentWaitAndCheckVisible(requiredStatementsHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(reviewCertification, driver);
        HelperMethods.waitAndClick(reviewCertification, driver);
        Thread.sleep(3000);
        HelperMethods.waitAndClick(saveAndContinue, driver);
    }
    public void completeReviewAndAuthorizeAndSubmit() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(reviewAndAuthorizationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(generatePDFButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(printedAndSavedConfirmationCheckBox, driver);
        HelperMethods.staleElementClick(printedAndSavedConfirmationCheckBox, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementVisible(submitButton, driver);
        HelperMethods.staleElementVisible(reviewAndAuthorizationHeading, driver);
        Thread.sleep(5500);
        HelperMethods.staleElementVisible(submitButton, driver);
        Thread.sleep(5500);
        HelperMethods.highLighterMethod(driver, submitButton);
        HelperMethods.fluentWaitAndCheckVisible(submitButton, driver);
        HelperMethods.staleElementClick(submitButton, driver);
    }

    public void completeReviewAndAuthorizeAndSubmitExtraProvincial() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(reviewAndAuthorizationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(printedAndSavedConfirmationCheckBox, driver);
        HelperMethods.staleElementClick(printedAndSavedConfirmationCheckBox, driver);
        HelperMethods.staleElementVisible(submitButtonExtraProvincial, driver);
        HelperMethods.staleElementVisible(reviewAndAuthorizationHeading, driver);
        Thread.sleep(2600);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonExtraProvincial, driver);
//        HelperMethods.staleElementSubmit(submitButtonExtraProvincial,driver);
   //     HelperMethods.scrollIntoViewForClick(submitButtonExtraProvincial, driver);
        HelperMethods.highLighterMethod(driver, submitButtonExtraProvincial);
        Thread.sleep(15000);
//        HelperMethods.fluentLongWaitAndClick(submitButtonExtraProvincial,driver);
//        HelperMethods.highLighterMethod(driver,submitButtonExtraProvincial);
        HelperMethods.waitAndClick(submitButtonExtraProvincial, driver);
    }

    public void completeReviewAndSubmitGeneralPartnership() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(reviewHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(printedAndSavedConfirmationCheckBox, driver);
        HelperMethods.staleElementClick(printedAndSavedConfirmationCheckBox, driver);
        HelperMethods.staleElementVisible(submitButtonGP, driver);
        HelperMethods.staleElementVisible(reviewHeading, driver);
        Thread.sleep(1600);
        HelperMethods.staleElementClick(submitButtonGP, driver);
    }

    public void completeReviewAndAuthorizeAndSubmitIncorporation() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(reviewAndAuthorizationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(generatePDFButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(printedAndSavedConfirmationCheckBox, driver);
        HelperMethods.staleElementClick(printedAndSavedConfirmationCheckBox, driver);
        HelperMethods.staleElementVisible(submitButtonReviewAuthorize, driver);
        HelperMethods.staleElementVisible(reviewAndAuthorizationHeading, driver);
        Thread.sleep(15500);
        HelperMethods.fluentWaitAndCheckVisible(submitButtonReviewAuthorize, driver);
        Thread.sleep(15500);
        HelperMethods.staleElementClick(submitButtonReviewAuthorize, driver);
    }

    public void completeReviewAndAuthorizeAndSubmitCorporation() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(reviewAndAuthorizationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(printedAndSavedConfirmationCheckBox, driver);
        HelperMethods.staleElementClick(printedAndSavedConfirmationCheckBox, driver);
        HelperMethods.staleElementVisible(submitButtonReviewAuthorizeInitialReturn, driver);
        HelperMethods.staleElementVisible(reviewAndAuthorizationHeading, driver);
        Thread.sleep(1500);
        HelperMethods.staleElementClick(submitButtonReviewAuthorizeInitialReturn, driver);
    }
    public void completegeneratePDFReviewAndAuthorizeAndSubmitCorporation() throws InterruptedException, AWTException {
        HelperMethods.fluentWaitAndCheckVisible(reviewAndAuthorizationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(printedAndSavedConfirmationCheckBox, driver);
        Thread.sleep(2500);
        HelperMethods.verifyElementEnabled(generatePDF, driver);
        HelperMethods.staleElementClick(printedAndSavedConfirmationCheckBox, driver);

        // **** NOTE & Warning: Script can NOT click on the 'Generate PDF' button which will freeze screen and framework will crash

//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//div[text()='Generate PDF']")), driver);
//        HelperMethods.waitAndClick(generatePDF, driver);
//        generatePDF.click();

//        Thread.sleep(3000);
//        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).build().perform();
//        Thread.sleep(5000);
//        System.out.println("Entering...");
//        HelperMethods.robotSendENTER();
//

//        Robot r = new Robot();
//        Thread.sleep(5000);
//        r.keyPress(KeyEvent.VK_ESCAPE);
//        Thread.sleep(5000);
//        r.keyRelease(KeyEvent.VK_ESCAPE);
//

        Thread.sleep(2500);
        HelperMethods.staleElementVisible(submitButtonReviewAuthorizeInitialReturn, driver);
        HelperMethods.staleElementVisible(reviewAndAuthorizationHeading, driver);
        Thread.sleep(1500);
        HelperMethods.staleElementClick(submitButtonReviewAuthorizeInitialReturn, driver);
    }

    public void terminationConfirmationAndSubmit() throws InterruptedException {
        HelperMethods.staleElementVisible(printedAndSavedConfirmationCheckBox, driver);
        HelperMethods.staleElementClick(printedAndSavedConfirmationCheckBox, driver);
        Thread.sleep(2500);
        HelperMethods.verifyElementEnabled(generatePDF, driver);
        Thread.sleep(2500);
        HelperMethods.fluentWaitAndCheckVisible(compliedWithSubSectionCheckBox, driver);
        HelperMethods.staleElementClick(compliedWithSubSectionCheckBox, driver);
        Thread.sleep(2500);
        HelperMethods.scrollIntoViewForClick(submitButtonExtraProvincial, driver);
        HelperMethods.staleElementClick(submitButtonExtraProvincial, driver);
    }
    public void completeJurisdictionAndNavigateToReview() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(jurisdictionProgressLink, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(jurisdictionProgressLink, driver);
        Thread.sleep(3000);
        HelperMethods.highLighterMethod(driver,jurisdictionProgressLink);
        Thread.sleep(3000);
        HelperMethods.staleElementClick(jurisdictionProgressLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(jurisdictionHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(currentCorporationNameLabel, driver);
        HelperMethods.fluentWaitAndCheckVisible(uploadButton.get(1), driver);
//        driver.findElement(By.xpath("//div[7]/div/div[2]/div/div[2]")).sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");
//        HelperMethods.waitAndSendKeys(uploadButton.get(1), "src/main/resources/uploadTest.txt", driver);
//        HelperMethods.waitAndSendKeys(uploadButton.get(2), "src/main/resources/SO.png", driver);


        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");

// trigger the upload
        driver.findElement(By.xpath("//div[contains(@class,'appDocumentsContainer continueInAsONBusinessCorp-asyncContainer-wizardBox-jurisdictionTab-serviceinstance-letterDocument-documents')]/following-sibling::button[1]"))
                .click();

// assign the file to the `<input>`
        driver.findElement(By.xpath("(//input[@type='file'])[2]"))
                .sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");

        HelperMethods.fluentWaitAndCheckVisible(jurisdictionHeading, driver);
//        HelperMethods.staleElementClick(uploadButton.get(1), driver);
//        driver.findElement(By.xpath("//div[contains(@class,'appDocumentsContainer continueInAsONBusinessCorp-asyncContainer-wizardBox-jurisdictionTab-serviceinstance-letterDocument-documents')]/following-sibling::div[1]"))
//                .click();
//
//        HelperMethods.waitAndSendKeys(uploadButtonInput, "C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf", driver);
//        driver.findElement(By.cssSelector("input[type=file]"))
//                .sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HelperMethods.staleElementClick(reviewAndAuthorizationProgressLink, driver);
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String completeFeePaymentDebit() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(paymentMethodOption, driver);
//        HelperMethods.selectOptionFromDropdownWithValueOf(Config.VISA_PAYMENT_EXPERATION_YEAR, paymentMethodOption, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf(Config.CREDIT_CARD_LABEL, paymentMethodOption, driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Thread.sleep(2500);
        HelperMethods.staleElementVisible(feePaymentContinueButton, driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Thread.sleep(2500);
        HelperMethods.staleElementClick(feePaymentContinueButton, driver);
        if (System.getenv("ENV").equals("BAT")) {
            HelperMethods.staleElementClick(driver.findElement(By.xpath("//input[@type='submit']")), driver);
        }
        else {
            HelperMethods.staleElementVisible(makePayment, driver);

//        if(HelperMethods.isObjectPresentByXpath(driver, "//span[text()='Continue']") >0) {
//            HelperMethods.staleElementVisible(continueButton, driver);
//            HelperMethods.fluentLongWaitAndClick(continueButton, driver);
//        }

            HelperMethods.staleElementVisible(cancelButton, driver);
            Thread.sleep(2500);
//        HelperMethods.staleElementClick(makePaymentButton, driver);
            HelperMethods.staleElementKeysEnter(makePayment, driver);
        }
        //Thread.sleep(9500);
        payByVisaCard();
// ++++++++++++++ OLD Payment Code
//        HelperMethods.staleElementVisible(namOnCardField, driver);
////      HelperMethods.staleElementVisible(submitPaymentButton, driver);
//// Commented payment method - Nov 09, 2021
////        HelperMethods.waitAndSendKeys(namOnCardField, Config.VISA_PAYMENT_NAME, driver);
////        HelperMethods.waitAndSendKeys(cardNumberField, Config.VISA_PAYMENT_NUMBER, driver);
////        HelperMethods.selectOptionFromDropdownWithValueOf(Config.VISA_PAYMENT_EXPERATION_YEAR, cardExpirationYear, driver);
////        HelperMethods.waitAndSendKeys(cardCVDNumberField, Config.VISA_PAYMENT_CVD_NUMBER, driver);
//
//// payment Master card as method - Nov 09, 2021
//        HelperMethods.waitAndSendKeys(namOnCardField, Config.VISA_PAYMENT_NAME, driver);
//        HelperMethods.selectOptionFromDropdownWithValueOf(Config.CARD_TYPE , cardType, driver);
//        HelperMethods.waitAndSendKeys(cardNumberField, Config.MASTER_PAYMENT_NUMBER, driver);
//        HelperMethods.selectOptionFromDropdownWithValueOf(Config.MASTER_PAYMENT_EXPERATION_YEAR , cardExpirationYear, driver);
//        HelperMethods.waitAndSendKeys(cardCVDNumberField, Config.MASTER_PAYMENT_CVD_NUMBER , driver);
//
//        Thread.sleep(3500);
////        HelperMethods.staleElementKeysEnter(submitPaymentButton, driver);
//        HelperMethods.staleElementClick(submitPaymentButton, driver);
// +++++++++++++++++++++++++

//        Thread.sleep(2500);
//[        retryOnPaymentFailure();  // To be added, if Payment fails
        retryOnPaymentFailure(); // To be deleted
//        retryOnPaymentFailure(); // To be deleted
//        Thread.sleep(2500);
//        HelperMethods.fluentWaitAndCheckVisible(paymentConfirmationContinueButton, driver);
        // May 16, 2022 - button labels have been changed and added new code
//        HelperMethods.fluentWaitAndCheckVisible(finalizeTransactionButton, driver);
//        Thread.sleep(2500);
//        String transactionNumber = driver.findElement(By.xpath("(//div[contains(@class,'appAttrText basketView-tabs-basketDetails-details-right-two-basketCode2')]//div)[2]")).getText();
//        Thread.sleep(2500);
////        HelperMethods.fluentLongerWaitAndClick(paymentConfirmationContinueButton, driver);
//
//        // May 16, 2022 - button labels have been changed and added new code
//        HelperMethods.fluentLongerWaitAndClick(finalizeTransactionButton, driver);
        return transactionNumber;
    }
// ++++++++
public String completepayByVisaCard() throws InterruptedException {
    HelperMethods.fluentWaitAndCheckVisible(paymentMethodOption, driver);
    HelperMethods.selectOptionFromDropdownWithValueOf(Config.CREDIT_CARD_LABEL, paymentMethodOption, driver);
    Thread.sleep(2500);
    HelperMethods.staleElementVisible(feePaymentContinueButton, driver);
    HelperMethods.staleElementClick(feePaymentContinueButton, driver);
//    boolean isCorrect = HelperMethods.checkVisible(feePaymentContinueButton, logger);
//    if (isCorrect == true) {
//        HelperMethods.staleElementClick(feePaymentContinueButton, driver);
//    }
//
//    HelperMethods.staleElementClick(feePaymentContinueButton, driver);
//    boolean isCorrect1 = HelperMethods.checkVisible(CCPayContinueButton, logger);
//    if (isCorrect1 == true) {
//        HelperMethods.staleElementClick(CCPayContinueButton, driver);
//    }

    HelperMethods.highLighterMethod(driver, makePaymentReTry); //     makePaymentButton1
    HelperMethods.waitAndClick(makePaymentReTry, driver);      // makePaymentButton1
//    HelperMethods.staleElementVisible(makePaymentButton, driver);
    payByVisaCard();
    Thread.sleep(2500);
//[        retryOnPaymentFailure();  // To be added, if Payment fails
    retryOnPaymentFailure(); // To be deleted
//        retryOnPaymentFailure(); // To be deleted
    Thread.sleep(2500);
//    HelperMethods.fluentWaitAndCheckVisible(paymentConfirmationContinueButton, driver);
//    HelperMethods.fluentWaitAndCheckVisible(finalizeTransactionButton, driver);
    Thread.sleep(2500);
//    String transactionNumber = code2Value.getText();
//    Thread.sleep(2500);
//    HelperMethods.fluentLongerWaitAndClick(paymentConfirmationContinueButton, driver);
//    HelperMethods.fluentLongerWaitAndClick(finalizeTransactionButton, driver);
    return transactionNumber;
}
// ++++++++++++++
public void  payByVisaCard() throws InterruptedException {
    HelperMethods.staleElementVisible(namOnCardFieldNew, driver);
//    HelperMethods.staleElementVisible(submitPaymentButtonNew, driver);
    HelperMethods.waitAndSendKeys(namOnCardFieldNew, Config.VISA_PAYMENT_NAME, driver);
    HelperMethods.waitAndSendKeys(cardNumberFieldNew, Config.VISA_PAYMENT_NUMBER, driver);
    HelperMethods.waitAndSendKeys(cardExpirationMM, Config.VISA_PAYMENT_EXPERATION_MM, driver);
    HelperMethods.waitAndSendKeys(cardExpirationYY, Config.VISA_PAYMENT_EXPERATION_YY, driver);
    HelperMethods.waitAndSendKeys(cardtrnCardCvd, Config.VISA_PAYMENT_CVD_NUMBER, driver);
 //   Thread.sleep(7000);
    driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
   // submitPaymentButtonNew.submit();
    HelperMethods.staleElementSubmit(submitPaymentButtonNew, driver);
}


    // Nov 08, 2021 - added if any payment fails, retry the payment once again   checkVisible
    public void  retryOnPaymentFailure() throws InterruptedException {
//        if (HelperMethods.staleElementVisible(paymentErrorMessage, logger)) {
        Thread.sleep(1000);
        if (HelperMethods.isElementVisible(paymentErrorMessage, logger)) {
            System.out.println("payment Error Message");
            Thread.sleep(1000);
            HelperMethods.staleElementVisible(makePaymentReTry, driver);
            HelperMethods.staleElementClick(makePaymentReTry, driver);
                HelperMethods.staleElementVisible(namOnCardFieldNew, driver);
                HelperMethods.staleElementVisible(submitPaymentButtonNew, driver);
                HelperMethods.waitAndSendKeys(namOnCardFieldNew, Config.VISA_PAYMENT_NAME, driver);
                HelperMethods.waitAndSendKeys(cardNumberFieldNew, Config.MASTER_PAYMENT_NUMBER, driver);
                HelperMethods.waitAndSendKeys(cardExpirationMM, Config.VISA_PAYMENT_EXPERATION_MM, driver);
                HelperMethods.waitAndSendKeys(cardExpirationYY, Config.VISA_PAYMENT_EXPERATION_YY, driver);
                HelperMethods.waitAndSendKeys(cardtrnCardCvd, Config.MASTER_PAYMENT_CVD_NUMBER, driver);
                Thread.sleep(1000);
                // submitPaymentButtonNew.submit();
                HelperMethods.staleElementSubmit(submitPaymentButtonNew, driver);
                // May 16, 2022 - button labels have been changed and added new code
//                HelperMethods.staleElementVisible(FinalizeTransactionNotificationOk, driver);
//                HelperMethods.fluentLongWaitAndClick(FinalizeTransactionNotificationOk, driver);
            }
//        }
    }
    public void completeFeePaymentCashIncorporation() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(paymentMethodOption, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf(Config.CASH_LABEL, paymentMethodOption, driver);
        Thread.sleep(7500);


        HelperMethods.staleElementVisible(feePaymentContinueButton, driver);
        HelperMethods.staleElementClick(feePaymentContinueButton, driver);
        // May 16, 2022 - button labels have been changed and added new code
//        HelperMethods.staleElementVisible(FinalizeTransactionNotificationOk, driver);
//        HelperMethods.staleElementClick(FinalizeTransactionNotificationOk, driver);

//        HelperMethods.staleElementVisible(paymentConfirmationContinueButtonCorporation, driver);
//        HelperMethods.staleElementClick(paymentConfirmationContinueButtonCorporation, driver);
        // May 16, 2022 - button labels have been changed and added new code
//        HelperMethods.staleElementVisible(finalizeTransactionButton, driver);
//        HelperMethods.staleElementClick(finalizeTransactionButton, driver);
    }
    public void confirmSentForReview() throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(sentForReviewTitle, driver);
        HelperMethods.fluentWaitAndCheckVisible(okButton, driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndCheckVisible(okButton, driver);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"sentForReviewDialogContent\"]/div")).getText());
        Reporter.log("corporation name and number is: " + driver.findElement(By.xpath("//*[@id=\"sentForReviewDialogContent\"]/div")).getText());
//        okButton.submit();
        HelperMethods.waitAndClick(okButton, driver);
        Thread.sleep(1000);
//        HelperMethods.highLighterMethod(driver, okButton);
        try {
            HelperMethods.robotSendENTER();
        } catch (AWTException e) {
            e.printStackTrace();
        }
 //       HelperMethods.waitAndClick(sentForReviewDialogOkButton, driver);
//        HelperMethods.staleElementClick(sentForReviewDialogOkButton, driver);

    }
//    public void confirmSentForReview() throws InterruptedException {
//        HelperMethods.fluentWaitAndCheckVisible(sentForReviewTitle, driver);
//        HelperMethods.highLighterMethod(driver, okButton);
//        HelperMethods.fluentWaitAndCheckVisible(okButton, driver);
////        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        HelperMethods.fluentWaitAndCheckVisible(okButton, driver);
////        try {
////            Thread.sleep(2000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//
////        HelperMethods.fluentWaitAndClick(okButton, driver);
////        HelperMethods.staleElementKeysEnter(sentForReviewokButton, driver);
////        HelperMethods.waitAndClick(sentForReviewokButton, driver);
////        HelperMethods.fluentWaitAndClick(okButton, driver);
////        try {
////            Thread.sleep(2500);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////        HelperMethods.highLighterMethod(driver, SaveAndContinueButton);
////        HelperMethods.fluentLongWaitAndClick(SaveAndContinueButton, driver);
//
//    }

    public void completeCorporationNameAsNumberAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(willThisCorporationHaveNumberNameYesButton, driver);
        HelperMethods.waitAndClick(willThisCorporationHaveNumberNameYesButton, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf("CORP.", legalElementForNumberName, driver);

        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
//        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateValue, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);
        HelperMethods.fluentWaitAndCheckVisible(legalElementForNumberName, driver);

        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityType, driver);
        HelperMethods.fluentWaitAndClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "484", driver);
        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);

    }

    public void completeCorporationNameAsNumberAndSaveIncorporation() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(willThisCorporationHaveNumberNameYesButton, driver);
        HelperMethods.waitAndClick(willThisCorporationHaveNumberNameYesButton, driver);
        HelperMethods.staleElementVisible(legalElementForNumberNameValue, driver);
        HelperMethods.waitAndClick(legalElementForNumberNameValue, driver);
//        HelperMethods.selectOptionFromDropdownWithValueOf("CORP.", legalElementForNumberName, driver);

        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
    }

    public void purposesAndProvisionsAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(purposesAndProvisionsHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(operateAsCharityYesOption, driver);
        HelperMethods.waitAndClick(operateAsCharityYesOption, driver);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//span[text()='The purposes of the corporation are:']/following::textarea")), Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//div[@class='appFieldHelp']/following-sibling::textarea[1]")), Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        Thread.sleep(3500);
        HelperMethods.scrollIntoViewForClick(saveAndContinueButton, driver);
        HelperMethods.waitAndClick(saveAndContinueButton, driver);

    }
    public void completePurposesAndProvisionsAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(purposesAndProvisionsHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(operateAsCharityYesOption, driver);
        HelperMethods.waitAndClick(operateAsCharityYesOption, driver);

// +++++
//Finding all iframe tags on a web page
//        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
//        int numberOfTags = elements.size();
//        System.out.println("No. of Iframes on this Web Page are: " +numberOfTags);

// Switch to the frame using the frame title
        driver.switchTo().frame(Purposes);
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "The purposes of the corporation are: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);

    //    driver.findElement(By.xpath("/html/body")).sendKeys("The purposes of the corporation are: " + Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime());
        driver.switchTo().defaultContent(); // Switch back to the frame using the defaultContent

        driver.switchTo().frame(SpecialProvisions);
//        driver.findElement(By.xpath("/html/body")).sendKeys("SoftwareTestingHelp.com ******");

        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("/html/body")), "If the corporation will have additional special provisions, enter them in the space below: " +Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
        // Print the frame source code
        //       System.out.println("Frame Source" +driver.getPageSource());

        // Switch back to main web page
        driver.switchTo().defaultContent();

        //*[contains(@title, 'SpecialProvisions')]
        //*[contains(@title, 'Purposes')]
        //iframe[contains(@title, 'Purposes')]
        //iframe[contains(@title, 'SpecialProvisions')]


//        HelperMethods.fluentWaitAndCheckVisible(purposeOfCorporationTextArea, driver);
//        HelperMethods.waitAndSendKeys(purposeOfCorporationTextArea, Config.PURPOSE_OF_CORPORATION_TEXT, driver);
//        HelperMethods.fluentWaitAndCheckVisible(additionalSpecialProvisionsTextArea, driver);
//        HelperMethods.waitAndSendKeys(additionalSpecialProvisionsTextArea, Config.ADDITIONAL_SPECIAL_PROVISIONS_TEXT + " - " + HelperMethods.getCurrentDate() +"; " + HelperMethods.getCurrentTime(), driver);
//        HelperMethods.fluentWaitAndCheckVisible(saveAndContinueButton, driver);
//        HelperMethods.fluentWaitAndCheckVisible(operateAsCharityYesOption, driver);
//        HelperMethods.fluentWaitAndCheckVisible(purposesAndProvisionsHeading, driver);
        Thread.sleep(3500);
        HelperMethods.scrollIntoViewForClick(saveAndContinueButton, driver);
        HelperMethods.waitAndClick(saveAndContinueButton, driver);
    }

    public void completeIncorporatorsAndSave() {
        HelperMethods.fluentWaitAndCheckVisible(incorporatorsHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void completeJurisdictionForExtraProvincialLicenceForeignCorpInternational() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(jurisdictionHeading, driver);
        HelperMethods.staleElementVisible(corporationPreviouslyRegisteredInOntarioNoOption, driver);
        HelperMethods.waitAndClick(corporationPreviouslyRegisteredInOntarioNoOption, driver);
//        HelperMethods.waitAndClick(governmentJurisdictionOption, driver);
//        HelperMethods.waitAndSendKeys(jurisdictionSearchArea, Config.UNITED_STATES_LABEL, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(governmentJurisdictionOption, driver);
        HelperMethods.waitAndClick(governmentJurisdictionOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(governmentJurisdictionOptionUS, driver);
        HelperMethods.waitAndClick(governmentJurisdictionOptionBermuda, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(jurisdictionDateSelectionIcon, driver);
//        HelperMethods.staleElementVisible(stateOption, driver);
//        HelperMethods.waitAndClick(stateOption, driver);
//        HelperMethods.fluentWaitAndCheckVisible(stateOptionArizona, driver);
//        HelperMethods.waitAndClick(stateOptionArizona, driver);
        HelperMethods.fluentWaitAndCheckVisible(jurisdictionDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationPreviouslyRegisteredInOntarioNoOption, driver);
        HelperMethods.waitAndClick(jurisdictionDateSelectionIcon, driver);
        Thread.sleep(2000);
        HelperMethods.waitAndClick(jurisdictionTodaysDate, driver);

        HelperMethods.fluentWaitAndCheckVisible(JurisdictionUploadButton, driver);

        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");

        driver.findElement(By.xpath("//button[contains(@id,'_upload_button')]"))
                .click();

        driver.findElement(By.cssSelector("input[type=file]"))
//                .sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");
//                .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1100);
        HelperMethods.scrollIntoViewForClick(saveAndContinueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinueButton, driver);
        Thread.sleep(1500);
        HelperMethods.staleElementClick(saveAndContinueButton, driver);
    }

    public void completeJurisdictionForExtraProvincialLicenceForeignCorp() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(jurisdictionHeading, driver);
        HelperMethods.staleElementVisible(corporationPreviouslyRegisteredInOntarioNoOption, driver);
        HelperMethods.waitAndClick(corporationPreviouslyRegisteredInOntarioNoOption, driver);
//        HelperMethods.waitAndClick(governmentJurisdictionOption, driver);
//        HelperMethods.waitAndSendKeys(jurisdictionSearchArea, Config.UNITED_STATES_LABEL, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(governmentJurisdictionOption, driver);
        HelperMethods.waitAndClick(governmentJurisdictionOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(governmentJurisdictionOptionUS, driver);
        HelperMethods.waitAndClick(governmentJurisdictionOptionUS, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(jurisdictionDateSelectionIcon, driver);
        HelperMethods.staleElementVisible(stateOption, driver);
        HelperMethods.waitAndClick(stateOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(stateOptionArizona, driver);
        HelperMethods.waitAndClick(stateOptionArizona, driver);
        HelperMethods.fluentWaitAndCheckVisible(jurisdictionDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationPreviouslyRegisteredInOntarioNoOption, driver);
        HelperMethods.waitAndClick(jurisdictionDateSelectionIcon, driver);
        Thread.sleep(2000);
        HelperMethods.waitAndClick(jurisdictionTodaysDate, driver);

        HelperMethods.fluentWaitAndCheckVisible(JurisdictionUploadButton, driver);

        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");

        driver.findElement(By.xpath("//button[contains(@id,'_upload_button')]"))
                .click();

        driver.findElement(By.cssSelector("input[type=file]"))
//                .sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");
//                .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1100);
        HelperMethods.scrollIntoViewForClick(saveAndContinueButton, driver);
        Thread.sleep(1100);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinueButton, driver);
        Thread.sleep(1500);
        HelperMethods.staleElementClick(saveAndContinueButton, driver);
    }

    public void completeChiefOfficerAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(chiefOfficerHeader, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationAppointedOptionYes, driver);
        HelperMethods.waitAndClick(corporationAppointedOptionYes, driver);

        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);

        HelperMethods.fluentWaitAndCheckVisible(findAddressButton, driver);
        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(2500);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.scrollIntoViewForClick(saveAndContinueButton, driver);
        HelperMethods.staleElementVisible(saveAndContinueButton, driver);
        HelperMethods.staleElementClick(saveAndContinueButton, driver);
    }

    public void completeCorporationdAsAgentAndSave() throws InterruptedException, IOException {
        HelperMethods.fluentWaitAndCheckVisible(appointmentOfAgentHeader, driver);
//        HelperMethods.fluentWaitAndCheckVisible(uploadButton.get(0), driver);

        HelperMethods.waitAndClick(CorporationTypeOption, driver);
        File resourcesDirectory = new File("src/main/resources");
        String invalidOntarioCorporationNumber = HelperMethods.readFromTextFile(resourcesDirectory +"/"+System.getenv("ENV")+"_CR_4302_OntarioBusinessIncorporation.txt") +222;
        HelperMethods.waitAndSendKeys(OntarioCorporationNumber,invalidOntarioCorporationNumber,driver);
        Thread.sleep(3000);
        boolean yesOrNo = HelperMethods.isElementDisplayedWait(selectOntarioCorporationNumber,driver,1);
        System.out.println(yesOrNo);
        if (!yesOrNo) {
            Reporter.log("This is a negative test  -> " + System.getProperty("line.separator") + "\n   The negative  OCN '" + invalidOntarioCorporationNumber + "' is NOT accepted in OBR");
            System.out.println("The negative  OCN '" + invalidOntarioCorporationNumber + "' is NOT accepted in OBR");
        }


        HelperMethods.waitAndSendKeys(OntarioCorporationNumber, HelperMethods.readFromTextFile(resourcesDirectory +"/"+System.getenv("ENV")+"_CR_4302_OntarioBusinessIncorporation.txt"),driver);
//        HelperMethods.readFromTextFile(resourcesDirectory +"/CR_4302_OntarioBusinessIncorporation.txt");
//span[@class='appLookupLeft left']/following-sibling::input[1]
        HelperMethods.fluentWaitAndCheckVisible(selectOntarioCorporationNumber, driver);
        HelperMethods.highLighterMethod(driver,selectOntarioCorporationNumber);
        Reporter.log("Ontario Business Incorporation number '" + selectOntarioCorporationNumber.getText() +"' was selected");
        HelperMethods.waitAndClick(selectOntarioCorporationNumber, driver);

//        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
//        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
//        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
//        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
//        Thread.sleep(900);
//        HelperMethods.scrollIntoViewForClick(findAddressButton, driver);
//        HelperMethods.fluentWaitAndCheckVisible(findAddressButton, driver);
//        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(2000);
        HelperMethods.staleElementVisible(uploadButtonNonList, driver);
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
        Thread.sleep(2000);
        HelperMethods.waitAndClick(uploadButtonNonList, driver);

        driver.findElement(By.cssSelector("input[type=file]"))
//                .sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");
//                .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1300);

        HelperMethods.staleElementVisible(contactInformationRemoveButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinueButton, driver);
        HelperMethods.staleElementClick(saveAndContinueButton, driver);
    }
    public void completeAgentForServiceAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(appointmentOfAgentHeader, driver);
        Thread.sleep(1000);
  //      HelperMethods.fluentWaitAndCheckVisible(uploadButton.get(0), driver);

        HelperMethods.waitAndClick(individualTypeOption, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(uploadButton.get(0), driver);
        HelperMethods.fluentWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);

//        HelperMethods.fluentWaitAndCheckVisible(enterAddressManuallyLink, driver);
        HelperMethods.waitAndSendKeys(addressLookupField, Config.POSTAL_CODE_VALUE, driver);
        Thread.sleep(900);
        HelperMethods.scrollIntoViewForClick(findAddressButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(findAddressButton, driver);
        HelperMethods.waitAndClick(findAddressButton, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.staleElementVisible(uploadButtonNonList, driver);
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
        Thread.sleep(2000);
        HelperMethods.waitAndClick(uploadButtonNonList, driver);

        driver.findElement(By.cssSelector("input[type=file]"))
//                .sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");
//                .sendKeys("C:\\workspace\\onbis-e2e\\src\\main\\resources\\123_pdf-file.pdf");
                .sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1300);

        HelperMethods.staleElementVisible(contactInformationRemoveButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinueButton, driver);
        HelperMethods.staleElementClick(saveAndContinueButton, driver);
    }

    public void completeGeneralDetailsAndSave() {
        HelperMethods.fluentWaitAndCheckVisible(requestDateForIncorporationDateValue, driver);
        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationDateSelectionIcon, driver);
        HelperMethods.fluentWaitAndClick(requestDateForIncorporationTodaysDate, driver);

        HelperMethods.staleElementClick(primaryActivityType, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "truck transportation", driver);
        HelperMethods.staleElementVisible(primaryActivityTypeTransportation, driver);
        HelperMethods.staleElementClick(primaryActivityTypeTransportation, driver);

        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);
        HelperMethods.waitAndSendKeys(officialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        HelperMethods.waitAndSendKeys(confirmOfficialEmailValue, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        HelperMethods.highLighterMethod(driver, saveAndContinue);
//        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void completeGeneralDetailsAndSaveInitialReturns() {
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);

        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
    }

    public void selectContinue() {
        HelperMethods.fluentWaitAndCheckVisible(paymentConfirmationContinueButton, driver);
        HelperMethods.staleElementClick(paymentConfirmationContinueButton, driver);
    }

    public boolean verifyFileArticlesOfContinuance () {
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("(//div[@class='appAttrValue'])[2]")), driver);
        logger.warn("File Articles Of Continuance Corporation name and number is: " + driver.findElement(By.xpath("//div[@class='appPageTitleInner']//span")).getText());
        Reporter.log("File Articles Of Continuance Corporation name and number is: " + driver.findElement(By.xpath("//div[@class='appPageTitleInner']//span")).getText());
        HelperMethods.highLighterMethod(driver,statusFileArticlesOfContinuance);
        isCorrect = statusFileArticlesOfContinuance.getText().contains("Inactive");
        logger.warn("File Articles Of Continuance status is: " + statusFileArticlesOfContinuance.getText());
        Reporter.log("File Articles Of Continuance status is: " + statusFileArticlesOfContinuance.getText());
        return isCorrect;
    }



    public boolean verifyFileArticlesOfDissolution() {
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("(//div[@class='appAttrValue'])[2]")), driver);
        logger.warn("View Corporation name and number is: " + driver.findElement(By.xpath("(//div[@class='appAttrValue'])[2]")).getText());
        Reporter.log("View Corporation name and number is: " + driver.findElement(By.xpath("(//div[@class='appAttrValue'])[2]")).getText());
        HelperMethods.highLighterMethod(driver,statusFileArticlesOfDissolution);
        isCorrect = statusFileArticlesOfDissolution.getText().contains("Inactive");
        logger.warn("File Articles Of Dissolution status is: " + statusFileArticlesOfDissolution.getText());
        Reporter.log("File Articles Of Dissolution status is: " + statusFileArticlesOfDissolution.getText());
        return isCorrect;
    }
    public boolean verifyFileArticlesOfContinuanceBusinessName() {
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("(//span[text()='Business Names'])[3]")), driver);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//span[text()='Show inactive Business Names']")));
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='Show inactive Business Names']")), driver);
        HelperMethods.highLighterMethod(driver, filerAticlesOfContinuanceBusinessName);
//span[text()='Show inactive Business Names']
        logger.warn("File Articles Of Continuance Business Name is: " + filerAticlesOfContinuanceBusinessName.getText());
        Reporter.log("File Articles Of Continuance Business Name is: " + filerAticlesOfContinuanceBusinessName.getText());
        HelperMethods.highLighterMethod(driver,statusArticlesOfContinuanceBusinessName);
        boolean isCorrect = statusArticlesOfContinuanceBusinessName.getText().contains("Inactive");
        logger.warn("Status for File Articles Of Continuance for Business Name is: " + statusArticlesOfContinuanceBusinessName.getText());
        Reporter.log("Status for File Articles Of Continuance for Business Name is: " + statusArticlesOfContinuanceBusinessName.getText());
        return isCorrect;
    }
    public boolean verifyFileArticlesOfDissolutionBusinessName() {
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("(//span[text()='Business Names'])[3]")), driver);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//span[text()='Show inactive Business Names']")));
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='Show inactive Business Names']")), driver);
        HelperMethods.highLighterMethod(driver, fileArticlesOfDissolutionBusinessName);

        logger.warn("File Articles Of Dissolution Business Name is: " + fileArticlesOfDissolutionBusinessName.getText());
        Reporter.log("File Articles Of Dissolution Business Name is: " + fileArticlesOfDissolutionBusinessName.getText());
        HelperMethods.highLighterMethod(driver,statusFileArticlesOfDissolutionBusinessName);
        boolean isCorrect = statusFileArticlesOfDissolutionBusinessName.getText().contains("Inactive");
        logger.warn("Status for File Articles Of Dissolution is: " + statusFileArticlesOfDissolutionBusinessName.getText());
        Reporter.log("Status for File Articles Of Dissolution is: " + statusFileArticlesOfDissolutionBusinessName.getText());
        return isCorrect;
    }
    public boolean OCNIsCompleted() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(dashboardHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(completedSubMenu, driver);
        HelperMethods.staleElementClick(completedSubMenu, driver);
        Thread.sleep(1000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(applicationTableHeading, driver);
        Thread.sleep(1000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(statusTableHeading, driver);
//        logger.warn("Completed OCN name: " + statusTableName.getText());
        logger.warn("OCN name and number is: " + descriptionName.getText());
        Reporter.log("OCN name and number is: " + descriptionName.getText());
//        isCorrect = isCorrect && HelperMethods.compareText(statusTableName, HelperMethods.randomString())
        return isCorrect;
    }

    public void selectSaveAndContinue() {
        HelperMethods.staleElementVisible(saveAndContinue, driver);
//        HelperMethods.fluentWaitAndCheckVisible(officialEmailValue, driver);

        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void selectSaveAndContinueOfficer() {
        HelperMethods.staleElementVisible(addAnOfficerButton, driver);
        HelperMethods.staleElementVisible(saveAndContinueOfficer, driver);
        HelperMethods.staleElementClick(saveAndContinueOfficer, driver);
    }

    public void completeCertification() throws InterruptedException {
        HelperMethods.staleElementVisible(certificationHeading, driver);
        HelperMethods.staleElementVisible(directorOrOfficerOption, driver);
        HelperMethods.staleElementClick(selectFromDirectorOrOfficerOption, driver);
        HelperMethods.selectOptionFromDropdownselectByIndex(1, driver.findElement(By.tagName("select")), driver);

//        HelperMethods.staleElementVisible(selectFromDirectorOptionAsContactFirstValue, driver);
//        HelperMethods.staleElementClick(selectFromDirectorOptionAsContactFirstValue, driver);
        Thread.sleep(900);
//        HelperMethods.staleElementVisible(nameLabel, driver);
        HelperMethods.staleElementVisible(confirmationCheckBoxCertification, driver);
        Thread.sleep(900);
        HelperMethods.staleElementClick(confirmationCheckBoxCertification, driver);
        Thread.sleep(800);
        HelperMethods.staleElementVisible(saveAndContinue, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void completeCertificationNoticeOfChangeAndSubmit() throws InterruptedException {
        HelperMethods.staleElementVisible(certificationHeading, driver);
        HelperMethods.staleElementVisible(directorOrOfficerOption, driver);
        HelperMethods.staleElementClick(selectFromDirectorOrOfficerOption, driver);
        HelperMethods.selectOptionFromDropdownselectByIndex(1, driver.findElement(By.tagName("select")), driver);
//        HelperMethods.staleElementVisible(selectFromDirectorOptionAsContactFirstValue, driver);
//        HelperMethods.staleElementClick(selectFromDirectorOptionAsContactFirstValue, driver);
        Thread.sleep(1500);
//        HelperMethods.staleElementVisible(nameLabel, driver);
        HelperMethods.staleElementVisible(confirmationCheckBoxCertification, driver);
        HelperMethods.staleElementClick(confirmationCheckBoxCertification, driver);
        Thread.sleep(800);
//        HelperMethods.staleElementVisible(submitButtonNoticeOfChange, driver);
//        HelperMethods.staleElementClick(submitButtonNoticeOfChange, driver);

        HelperMethods.staleElementVisible(informationOnFileSaveAndContinue, driver);
        HelperMethods.staleElementClick(informationOnFileSaveAndContinue, driver);

        HelperMethods.staleElementVisible(reviewCertification, driver);
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label[1]")));
        Thread.sleep(7800);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label[1]")), driver);
        Thread.sleep(2800);

        HelperMethods.staleElementVisible(Submit, driver);
        Thread.sleep(4800);
        HelperMethods.fluentWaitAndClick(Submit, driver);

    }
    public void selectGeneralDetails() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(generalDetails, driver);
        HelperMethods.fluentWaitAndClick(generalDetails, driver);
        HelperMethods.highLighterMethod(driver,reregistrationDate);
        Thread.sleep(2000);
        HelperMethods.waitAndSendKeys(reregistrationDate, HelperMethods.getFutureDate(0), driver);
        Thread.sleep(2000);
    }
    public void generalDetailActivityInOntarioDate() throws InterruptedException {
        // Switch back to main web page
//        driver.switchTo().defaultContent();
        HelperMethods.fluentWaitAndCheckVisible(generalDetails, driver);
        HelperMethods.fluentWaitAndClick(generalDetails, driver);
        Thread.sleep(3000);
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//input[@class='webuiValidateDate hasDatepicker']")));
        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//input[@class='webuiValidateDate hasDatepicker']")), HelperMethods.getPreviousDate(0), driver);
        HelperMethods.highLighterMethod(driver, ceasedActivityInOntarioDate);
        HelperMethods.waitAndSendKeys(ceasedActivityInOntarioDate, HelperMethods.getPreviousDate(0), driver);


    }
    public void selectCertification() {
        HelperMethods.fluentWaitAndCheckVisible(certificationStepLink, driver);
        HelperMethods.fluentWaitAndClick(certificationStepLink, driver);
    }

    public boolean initialReturnIsCreated() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(initialReturnLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(noticeOfChangeLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        HelperMethods.staleElementClick(noticeOfChangeLabel, driver);
        Thread.sleep(2200);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);

        String oCN = driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText();
        Reporter.log("Particulars of CIA - Initial Return is :" + oCN);
        HelperMethods.writeToCSV("REG_CIA015_InitialReturnForAnExtraProvincialCorp", oCN);
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
        System.out.println("Transaction Number is :" + transactionNumberValue.getText());
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }
    public boolean initialAndNoticeOChangeReturnIsCreated() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(initialReturnLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(noticeOfChangeLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        HelperMethods.staleElementClick(bcaArticleOfIncorporationFiling, driver);
        Thread.sleep(2200);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);


        Reporter.log("Particulars of BCA - Articles of Incorporation is :" + driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText());
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
        System.out.println("Transaction Number is :" + transactionNumberValue.getText());
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }

    public boolean noticeOChangeIsCreated() throws InterruptedException {
       // boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='CIA – Notice of Change – Administrative Changes']")), driver);
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(noticeOfChangeLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        HelperMethods.staleElementClick(noticeOfChangeLabel, driver);
        Thread.sleep(2200);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);

        String oCN = driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText();
        Reporter.log("Particulars of CIA – Notice of Change – Administrative Changes is :" + oCN);
//        HelperMethods.writeToCSV("REG_CIA016_NoticeOfChangeForAnExtraProvincialCorp", oCN);
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
        System.out.println("Transaction Number is :" + transactionNumberValue.getText());
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        HelperMethods.staleElementClick(FinalizeTransactionNotificationOk, driver);


        return isCorrect;
    }

    public boolean verificationPFCWithShare_EntityNameJurisdictionNonEditable() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(registerExtraProvincialForeignLicence, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(noticeOfChangeLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        HelperMethods.staleElementClick(registerExtraProvincialForeignLicence, driver);
        Thread.sleep(2200);
        HelperMethods.highLighterMethod(driver, transactionNumberValue);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,-700)");

        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")));
//        driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText().contains(returnABusinessNumber);
        Reporter.log("The OCN and the name of the corporation As Agent is displayed on the output as :" + driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText());
        HelperMethods.highLighterMethod(driver, transactionNumberValue);
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
        System.out.println("Transaction Number is :" + transactionNumberValue.getText());
        Reporter.log("The Receipt Date is displayed on the Filing Document as :" + driver.findElement(By.cssSelector("html>body>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(6)>div:nth-of-type(4)>div")).getText());
        Reporter.log("The Incorporation/Amalgamation Date is displayed on the Filing Document as :" + driver.findElement(By.xpath("//div[@class='appAttrValue']//span")).getText());


        Thread.sleep(2900);


        return isCorrect;
    }
    public boolean verificationPFCWithShare_FileArticlesOfContinuance() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(registerExtraProvincialForeignLicence, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(noticeOfChangeLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        HelperMethods.staleElementClick(registerExtraProvincialForeignLicence, driver);
        Thread.sleep(2200);
        HelperMethods.highLighterMethod(driver, transactionNumberValue);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-700)");

        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")));
//        driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText().contains(returnABusinessNumber);
        Reporter.log("The OCN and the name of the corporation As Agent is displayed on the output as :" + driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText());
        HelperMethods.highLighterMethod(driver, transactionNumberValue);
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
        System.out.println("Transaction Number is :" + transactionNumberValue.getText());
        Reporter.log("The Receipt Date is displayed on the Filing Document as :" + driver.findElement(By.cssSelector("html>body>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(6)>div:nth-of-type(4)>div")).getText());
        Reporter.log("The Incorporation/Amalgamation Date is displayed on the Filing Document as :" + driver.findElement(By.xpath("//div[@class='appAttrValue']//span")).getText());


        Thread.sleep(2900);


        return isCorrect;
    }
    public boolean verificationExtraProvincialForeignLicence() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(registerExtraProvincialForeignLicence, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(noticeOfChangeLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        HelperMethods.staleElementClick(registerExtraProvincialForeignLicence, driver);
        Thread.sleep(2200);
        HelperMethods.highLighterMethod(driver, transactionNumberValue);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-700)");

        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")));
//        driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText().contains(returnABusinessNumber);
        Reporter.log("The OCN and the name of the corporation As Agent is displayed on the output as :" + driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText());
        HelperMethods.highLighterMethod(driver, transactionNumberValue);
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
        System.out.println("Transaction Number is :" + transactionNumberValue.getText());
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);


        return isCorrect;
    }
    public boolean verificationRegisterBusinessNameForSoleProp() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(registerBusinessNameForSoleProp, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(noticeOfChangeLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        HelperMethods.staleElementClick(registerBusinessNameForSoleProp, driver);
        Thread.sleep(2200);
        HelperMethods.highLighterMethod(driver, transactionNumberValue);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-700)");

        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")));
//        driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText().contains(returnABusinessNumber);
        Reporter.log("Business Name Registration for a Sole Proprietorship is :" + driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText());
        HelperMethods.highLighterMethod(driver, transactionNumberValue);
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
        System.out.println("Transaction Number is :" + transactionNumberValue.getText());
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);

        return isCorrect;
    }
    public boolean initialAndAnnualReturnIsCreated() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(initialReturnLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(annualReturnLabel, driver);
        logger.warn("Corporation Name and Number is: " + pageTitleArticle.getText());

        HelperMethods.staleElementClick(bcaArticleOfIncorporationFiling, driver);
        Thread.sleep(2200);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        Reporter.log("Transaction Number is: " + transactionNumberValue.getText());
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")));
        Reporter.log("Particulars of EPCA - Extra-Provincial Foreign Licence is: " + driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText());
        System.out.println("Particulars of EPCA - Extra-Provincial Foreign Licence is: " + driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")));
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }

    public boolean annualReturnIsCreated() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(annualReturnLabel, driver);
        logger.warn("Corporation Name and Number is: " + corpNameAndNumber.getText());
        Reporter.log("Corporation Name and Number is: " + corpNameAndNumber.getText());
        HelperMethods.writeToCSV("REG_CIA002_AnnualReturnForAOntarioBusinessCorporation",  corpNameAndNumber.getText());

        HelperMethods.staleElementClick(annualReturnLabel, driver);
        Thread.sleep(2200);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        Reporter.log("Transaction Number is: " + transactionNumberValue.getText());
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")));
        Reporter.log("Particulars of Annual Return is: " + driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText());
        System.out.println("Particulars of Annual Return is: " + driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")));
        Reporter.log("Filing Date: " + driver.findElement(By.xpath("//div[text()='Filing Date']/following-sibling::div")).getText());
        Thread.sleep(2900);
        return isCorrect;
    }
    public void reviewDashboardAndApproveFromWorkQueueEP(String bName) throws InterruptedException {
//        Thread.sleep(1900);

        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("(//span[text()='Dashboard'])[2]")), driver);
        HelperMethods.fluentWaitAndCheckVisible(servicesTab, driver);
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("(//span[text()='Dashboard'])[2]")));
        HelperMethods.staleElementClick(driver.findElement(By.xpath("(//span[text()='Dashboard'])[2]")), driver);

        Thread.sleep(2000);

        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//span[text()='Work Queue ']")));
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Work Queue ']")), driver);
        Thread.sleep(3000);
        //span[text()='Work Queue ']
        // Dec 29, 2023 - Functionality (allocatedToMe) has been changed
//        HelperMethods.highLighterMethod(driver, allocatedToMe);
//        HelperMethods.staleElementClick(allocatedToMe, driver);

//        if (allocatedToMe.isSelected()) {
//            HelperMethods.staleElementClick(allocatedToMe, driver);
//            System.out.println("allocatedToMe.isSelected() ----> " + allocatedToMe.isSelected());
//        }
//        if (!allocatedToMe.isSelected()) {
//            HelperMethods.staleElementClick(allocatedToMe, driver);
//            System.out.println("allocatedToMe.isSelected() ----> " + allocatedToMe.isSelected());
//        }
        Thread.sleep(7000);


//        HelperMethods.fluentWaitAndCheckVisible(completedSubMenu, driver);
        System.out.println("showfilter element text :" + showFilterOption.getText());
            Thread.sleep(2000);
            HelperMethods.staleElementVisible(nameFieldSearch, driver);
            HelperMethods.waitAndSendKeys(nameFieldSearch, bName, driver);
            Thread.sleep(6000);
             HelperMethods.staleElementVisible(searchIcon, driver);
            HelperMethods.staleElementClick(searchIcon, driver);
            Thread.sleep(10000);
            HelperMethods.highLighterMethod(driver,doItNowLink);
            HelperMethods.staleElementVisible(doItNowLink, driver);
            Thread.sleep(2000);
            HelperMethods.staleElementClick(doItNowLink, driver);
//            HelperMethods.linkSubmit(doItNowLink, "Do It Now Link");

            Thread.sleep(1500);
            HelperMethods.staleElementVisible(driver.findElement(By.xpath("//*[contains(text(),'Approve')]")), driver);
            HelperMethods.staleElementClick(driver.findElement(By.xpath("//*[contains(text(),'Approve')]")), driver);
            Thread.sleep(3000);
       // }
        driver.getWindowHandle();
        HelperMethods.switchWindow(driver);
        Thread.sleep(4000);
        HelperMethods.staleElementVisible(driver.findElement(By.cssSelector("html>body>div:nth-of-type(5)>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div>div>button>span:nth-of-type(2)")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.cssSelector("html>body>div:nth-of-type(5)>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div>div>button>span:nth-of-type(2)")), driver);
        Thread.sleep(1000);
    }
    public void reviewAndApproveFromWorkQueueEP(String bName) throws InterruptedException {
//        Thread.sleep(1900);
        HelperMethods.fluentWaitAndCheckVisible(servicesTab, driver);
        Thread.sleep(2000);
//        HelperMethods.fluentWaitAndCheckVisible(completedSubMenu, driver);
        System.out.println("showfilter element text :" + showFilterOption.getText());
        if (!(showFilterOption.getText().equals(Config.HIDE_FILTER_LABEL))) {
//        if (!hideFilterOption.isDisplayed()) {
            HelperMethods.highLighterMethod(driver, showFilter);
            HelperMethods.staleElementClick(showFilter, driver);
            Thread.sleep(1000);
            HelperMethods.staleElementVisible(nameFieldSearch, driver);
            HelperMethods.waitAndSendKeys(nameFieldSearch, bName, driver);
            HelperMethods.staleElementClick(searchIcon, driver);
            HelperMethods.staleElementVisible(doItNowLink, driver);
            HelperMethods.staleElementClick(doItNowLink, driver);
            Thread.sleep(1500);
            HelperMethods.staleElementVisible(approveFormButton, driver);
            HelperMethods.staleElementClick(approveFormButton, driver);
            Thread.sleep(2000);
        } else {
            Thread.sleep(2000);
            HelperMethods.staleElementVisible(nameFieldSearch, driver);
            HelperMethods.waitAndSendKeys(nameFieldSearch, bName, driver);
            HelperMethods.staleElementClick(searchIcon, driver);
            Thread.sleep(2000);
            HelperMethods.highLighterMethod(driver,doItNowLink);
            HelperMethods.staleElementVisible(doItNowLink, driver);
            Thread.sleep(2000);
            HelperMethods.staleElementClick(doItNowLink, driver);
//            HelperMethods.linkSubmit(doItNowLink, "Do It Now Link");

            Thread.sleep(1500);
            HelperMethods.staleElementVisible(approveFormButton, driver);
            HelperMethods.staleElementClick(approveFormButton, driver);
            Thread.sleep(1000);
        }
        driver.getWindowHandle();
        HelperMethods.staleElementVisible(approveFormConfirmationButton, driver);
        HelperMethods.staleElementClick(approveFormConfirmationButton, driver);
        Thread.sleep(1000);
    }

    public String reviewCompanyNameAndApproveFromWorkQueue(String companyName) throws InterruptedException {
//        Thread.sleep(1900);
        String CompanyNumber = null;
        HelperMethods.fluentWaitAndCheckVisible(servicesTab, driver);
        Thread.sleep(2000);
//        HelperMethods.fluentWaitAndCheckVisible(completedSubMenu, driver);
        System.out.println("showfilter element text :" + showFilterOption.getText());
        if (!(showFilterOption.getText().equals(Config.HIDE_FILTER_LABEL))) {
//        if (!hideFilterOption.isDisplayed()) {
            HelperMethods.highLighterMethod(driver, showFilter);
            HelperMethods.staleElementClick(showFilter, driver);
            Thread.sleep(1000);
            HelperMethods.staleElementVisible(nameFieldSearch, driver);
            HelperMethods.waitAndSendKeys(nameFieldSearch, companyName, driver);
            HelperMethods.staleElementClick(searchIcon, driver);
            HelperMethods.staleElementVisible(doItNowLink, driver);
            HelperMethods.staleElementClick(doItNowLink, driver);
            Thread.sleep(1500);
            HelperMethods.staleElementVisible(approveFormButton, driver);
            HelperMethods.staleElementClick(approveFormButton, driver);
            Thread.sleep(2000);
        } else {
            Thread.sleep(2000);
            HelperMethods.staleElementVisible(nameFieldSearch, driver);
            HelperMethods.waitAndSendKeys(nameFieldSearch, companyName, driver);
            HelperMethods.staleElementClick(searchIcon, driver);
            Thread.sleep(2000);
            HelperMethods.highLighterMethod(driver,doItNowLink);
            HelperMethods.staleElementVisible(doItNowLink, driver);
            Thread.sleep(2000);
            HelperMethods.staleElementClick(doItNowLink, driver);
//            HelperMethods.linkSubmit(doItNowLink, "Do It Now Link");
            String CompanyNumName = driver.findElement(By.xpath("//h1[@class='appPageTitle']//span[1]")).getText();
             CompanyNumber = HelperMethods.getNumberFromString(CompanyNumName,"\\d+") ;

            System.out.println("Company Number is: " + CompanyNumber);
//            HelperMethods.highLighterMethod(driver,driver.findElement(By.cssSelector("form#viewInstanceForm>div>div>div>div:nth-of-type(2)>div>div:nth-of-type(3)>div>div>div:nth-of-type(11)>div:nth-of-type(2)")));
//            System.out.println("Company Number" + driver.findElement(By.cssSelector("form#viewInstanceForm>div>div>div>div:nth-of-type(2)>div>div:nth-of-type(3)>div>div>div:nth-of-type(11)>div:nth-of-type(2)")).getText());
            Thread.sleep(1500);
            HelperMethods.staleElementVisible(approveFormButton, driver);
            HelperMethods.staleElementClick(approveFormButton, driver);
            Thread.sleep(1000);
        }
        driver.getWindowHandle();
        HelperMethods.staleElementVisible(approveFormConfirmationButton, driver);
        HelperMethods.staleElementClick(approveFormConfirmationButton, driver);
        Thread.sleep(1000);
        return CompanyNumber;
    }
    public String reviewAndApproveFromWorkQueue() throws InterruptedException {
        Thread.sleep(1900);
        String CompanyNumber = null;
        HelperMethods.fluentWaitAndCheckVisible(servicesTab, driver);
        Thread.sleep(2000);
//        HelperMethods.fluentWaitAndCheckVisible(completedSubMenu, driver);
        System.out.println("showfilter element text :" + showFilterOption.getText());
        if (!(showFilterOption.getText().equals(Config.HIDE_FILTER_LABEL))) {
//        if (!hideFilterOption.isDisplayed()) {
            HelperMethods.highLighterMethod(driver, showFilter);
            HelperMethods.staleElementClick(showFilter, driver);
            Thread.sleep(1000);
            HelperMethods.staleElementVisible(nameFieldSearch, driver);
            HelperMethods.waitAndSendKeys(nameFieldSearch, getExtraProvincialCorporation(), driver);
            HelperMethods.staleElementClick(searchIcon, driver);
            HelperMethods.staleElementVisible(doItNowLink, driver);
            HelperMethods.staleElementClick(doItNowLink, driver);
            Thread.sleep(1500);
            HelperMethods.staleElementVisible(approveFormButton, driver);
            HelperMethods.staleElementClick(approveFormButton, driver);
            Thread.sleep(2000);
        } else {
            Thread.sleep(2000);
            HelperMethods.staleElementVisible(nameFieldSearch, driver);
            HelperMethods.waitAndSendKeys(nameFieldSearch, getExtraProvincialCorporation(), driver);
            HelperMethods.staleElementClick(searchIcon, driver);
            Thread.sleep(2000);
            HelperMethods.highLighterMethod(driver,doItNowLink);
            HelperMethods.staleElementVisible(doItNowLink, driver);
            Thread.sleep(2000);
            HelperMethods.staleElementClick(doItNowLink, driver);
//            HelperMethods.linkSubmit(doItNowLink, "Do It Now Link");
            String CompanyNumName = driver.findElement(By.xpath("//h1[@class='appPageTitle']//span[1]")).getText();
            CompanyNumber = HelperMethods.getNumberFromString(CompanyNumName,"\\d+") ;

            System.out.println("Company Number is: " + CompanyNumber);
//            HelperMethods.highLighterMethod(driver,driver.findElement(By.cssSelector("form#viewInstanceForm>div>div>div>div:nth-of-type(2)>div>div:nth-of-type(3)>div>div>div:nth-of-type(11)>div:nth-of-type(2)")));
//            System.out.println("Company Number" + driver.findElement(By.cssSelector("form#viewInstanceForm>div>div>div>div:nth-of-type(2)>div>div:nth-of-type(3)>div>div>div:nth-of-type(11)>div:nth-of-type(2)")).getText());
            Thread.sleep(1500);
            HelperMethods.staleElementVisible(approveFormButton, driver);
            HelperMethods.staleElementClick(approveFormButton, driver);
            Thread.sleep(1000);
        }
        driver.getWindowHandle();
        HelperMethods.staleElementVisible(approveFormConfirmationButton, driver);
        HelperMethods.staleElementClick(approveFormConfirmationButton, driver);
        Thread.sleep(1000);
        return CompanyNumber;
    }
    //
    public String writeOCNToCSV(String scriptName) throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//input[@class='keepInteractiveOnSubmit']")));
        String oCN = driver.findElement(By.xpath("//input[@class='keepInteractiveOnSubmit' and @tabindex='0']"))
                .getAttribute("value");
//        String oCN = driver.findElement(By.xpath("//input[@class='keepInteractiveOnSubmit']")).getText();
        HelperMethods.writeToCSV(scriptName, oCN);
        System.out.println("-------: OCN Number is: " + oCN + ":-------");
        return oCN;
    }
    public String writeOCNToCSVFromGeneralDetails(String scriptName) throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("(//div[@class='appAttrValue'])[3]")));
        String oCN = driver.findElement(By.xpath("(//div[@class='appAttrValue'])[3]")).getText();
//        String oCN = driver.findElement(By.xpath("//input[@class='keepInteractiveOnSubmit']")).getText();
        HelperMethods.writeToCSV(scriptName, oCN);
        System.out.println("-------: OCN Number is: " + oCN + ":-------");
        return oCN;
    }
    //

    public void completeCertificationInitialReturnAndSubmit() throws InterruptedException {
        HelperMethods.staleElementVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.staleElementVisible(authorizationCheckBox, driver);
        HelperMethods.staleElementClick(authorizationCheckBox, driver);
        Thread.sleep(900);
        HelperMethods.staleElementVisible(saveAndContinueButton, driver);
        HelperMethods.staleElementClick(saveAndContinueButton, driver);
    }

    public void completeCertificationInitialReturnAndSubmitExtraProvincial() throws InterruptedException {
        HelperMethods.staleElementVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.staleElementVisible(authorizationCheckBox, driver);
        HelperMethods.staleElementClick(authorizationCheckBox, driver);
        Thread.sleep(3000);
        HelperMethods.staleElementVisible(SaveAndContinueButton, driver);
        HelperMethods.staleElementClick(SaveAndContinueButton, driver);

        HelperMethods.fluentWaitAndCheckVisible(printedAndSavedConfirmationCheckBox, driver);
        Thread.sleep(10000);
        HelperMethods.waitAndClick(printedAndSavedConfirmationCheckBox, driver);
        Thread.sleep(5000);
        HelperMethods.staleElementVisible(submitButtonExtraProvincial, driver);
        HelperMethods.staleElementClick(submitButtonExtraProvincial, driver);

    }

    public void completeFirmNameAndSave() {
        String firmName = HelperMethods.randomString() + " General Partnership";
        HelperMethods.fluentWaitAndCheckVisible(checkNameButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(firmNameField, driver);
        HelperMethods.waitAndSendKeys(firmNameField, firmName, driver);
        HelperMethods.waitAndSendKeys(primaryActivityType, "484", driver);

        HelperMethods.fluentWaitAndCheckVisible(changeButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(emailField, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_EMAIL_VALUE, driver);

        HelperMethods.staleElementVisible(saveAndContinueButton, driver);
        HelperMethods.staleElementClick(saveAndContinueButton, driver);
    }

    public void completeAddressSameAsAndSave() {
        HelperMethods.fluentWaitAndCheckVisible(placeOfBusinessYes, driver);
        HelperMethods.fluentWaitAndClick(placeOfBusinessYes, driver);
        HelperMethods.fluentWaitAndCheckVisible(findAddressTextArea, driver);
        HelperMethods.waitAndSendKeys(findAddressTextArea, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.fluentWaitAndClick(findAddressButton, driver);
        HelperMethods.fluentWaitAndClick(pcLookupSelection, driver);
        HelperMethods.fluentWaitAndClick(pcLookupOkButton, driver);
        HelperMethods.staleElementVisible(streetNumberValue, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
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
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void completeAuthorizationForGeneralPartnershipAndSave() {
        HelperMethods.fluentWaitAndCheckVisible(authorizationHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinue, driver);
        HelperMethods.fluentWaitAndCheckVisible(personAuthorizingOption, driver);
        HelperMethods.waitAndClick(selectFromPartnersDropdownContainer, driver);
        HelperMethods.waitAndSendKeys(partnerTextArea, "Contact", driver);
        HelperMethods.fluentWaitAndCheckVisible(selectFirstPartner, driver);
        HelperMethods.waitAndClick(selectFirstPartner, driver);
        HelperMethods.fluentWaitAndCheckVisible(authorizationHeading, driver);
        HelperMethods.staleElementClick(saveAndContinue, driver);
    }

    public void selectAnnualReturnYear() throws InterruptedException {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        HelperMethods.fluentWaitAndCheckVisible(annualReturnYearDropdown, driver);
//        HelperMethods.selectOptionFromDropdownWithValueOf("2021", annualReturnYearDropdown, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf(String.valueOf(year), annualReturnYearDropdown, driver);


        Thread.sleep(1200);
    }

    public boolean emailContentIsDisplayed() {
        boolean isCorrect = GenericUtilsPage.validateEmailReceived().equals(getTransactionNumber());
        return isCorrect;
    }
    public void fileArticlesOfDissolutionOption() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfDissolutionOption, driver);
        HelperMethods.highLighterMethod(driver,fileArticlesOfDissolutionOption);
        HelperMethods.staleElementClick(fileArticlesOfDissolutionOption, driver);
    }
    public void noticeOfSpecialResolutionOption() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(noticeOfSpecialResolutionOption, driver);
        HelperMethods.highLighterMethod(driver,noticeOfSpecialResolutionOption);
        HelperMethods.staleElementClick(noticeOfSpecialResolutionOption, driver);
    }
    //span[text()='Notice of Special Resolution']   noticeOfSpecialResolutionOption


    public void fileApplicationForTerminationOfExtraProvincialLicenceOption() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileApplicationForTerminationOfExtraProvincialLicenceOption, driver);
        HelperMethods.highLighterMethod(driver,fileApplicationForTerminationOfExtraProvincialLicenceOption);
        HelperMethods.staleElementClick(fileApplicationForTerminationOfExtraProvincialLicenceOption, driver);
    }

    public void fileApplicationForAmendedExtraProvincialLicenceOption() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileApplicationForTerminationOfAmendedExtraProvincialLicenceOption, driver);
        HelperMethods.highLighterMethod(driver,fileApplicationForTerminationOfAmendedExtraProvincialLicenceOption);
        HelperMethods.staleElementClick(fileApplicationForTerminationOfAmendedExtraProvincialLicenceOption, driver);
    }

    public void fileArticlesOfDissolution_VoluntaryDissolution() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::label)[2]")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::label)[3]")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::label)[4]")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//input[@type='radio']/following-sibling::label")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//input[@value='charitableNFPCA']/following-sibling::label[1]")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.cssSelector("form#viewInstanceForm>div:nth-of-type(2)>div>div>div>div:nth-of-type(3)>div:nth-of-type(3)>div>div:nth-of-type(3)>div>div>div>div>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(2)>div>div>div:nth-of-type(2)>div>label")), driver);
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndCheckVisible(Submit, driver);
        HelperMethods.highLighterMethod(driver,Submit);
        HelperMethods.staleElementClick(Submit, driver);
    }
    public void selectFileDraftPlanOfArrangement() {
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Make Changes']")), driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='Make Changes']")), driver);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='File Draft Plan of Arrangement']")), driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='File Draft Plan of Arrangement']")), driver);
    }
    public void fileArticlesOfArrangement() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfArrangementIncorporationOption, driver);
        HelperMethods.staleElementClick(fileArticlesOfArrangementIncorporationOption, driver);
    }
    public void registerABusinessName() throws InterruptedException {
        Thread.sleep(1000);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndCheckVisible(businessNames, driver);
        Thread.sleep(5000);
        HelperMethods.staleElementClick(businessNames, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerABusinessNames, driver);
        HelperMethods.fluentWaitAndClick(registerABusinessNames, driver);
    }
    public void CompletedOCNwriteToCSV(String scriptName) throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(@class, 'appSpaces1') and contains(@class, 'appLines1') and contains(text(), 'Completed')]")), driver);
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("(//div[contains(@class, 'appAttrValue')])[2]")));
        String oCN = driver.findElement(By.xpath("(//div[contains(@class, 'appAttrValue')])[2]")).getText();
        System.out.println("Ontario Corporation Number (OCN) number is: " + oCN);
        HelperMethods.writeToCSV(scriptName, oCN);
    }
    public void SOAccountHomepageOCNwriteToCSV(String scriptName) throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//tbody[@id='service-table-body']//a[1] | //a[contains(text(), 'File Articles of Continuance under the Business Corporations')]")));
        String oCN = driver.findElement(By.xpath("//tbody[@id='service-table-body']//a[1] | //a[contains(text(), 'File Articles of Continuance under the Business Corporations')]")).getText();
        System.out.println("\tOntario business registry - Ontario Corporation Number (OCN) number is: " + oCN);
        HelperMethods.writeToCSV(scriptName, oCN);
    }
    public void GeneralDetailsOCNwriteToCSV(String scriptName) throws InterruptedException {
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(@class, 'appSpaces1')][contains(@class, 'appLines1')][text()='General Details']")), driver);
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("(//div[@class='appAttrValue'])[3]")));
        String oCN = driver.findElement(By.xpath("(//div[@class='appAttrValue'])[3]")).getText();
        System.out.println("Ontario Corporation Number (OCN) number is: " + oCN);
        HelperMethods.writeToCSV(scriptName, oCN);
    }
}
