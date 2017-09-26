package AutomationFramework;

public class TestData {



    public static final String ENV = "http://ro-test.rbro.rbg.cc";
    public static final String FE_BASE_URL = ENV + "/portalserver/raiffeisen-portal/login";
    public static final String BE_BASE_URL = ENV + "/portalserver/login/loginDashboard.jsp";
    public static final String FE_WU_RECEIVE_URL = "/portalserver/raiffeisen-portal/western-union/initiaza-transfer";


    public static final String FE_WU_RECIEVE_URL = FE_BASE_URL + "";


    // -------------------------------------------------------------------- USERS

    public static final String ADMIN_ACCOUNT = "admin";
    public static final String ADMIN_PASSWORD = "admin";

    public static final String VN_84_VLY = "vn-84-vly";
    public static final String USER_PASS = "test1234";


    // -------------------------------------------------------------------- Waiting Time
    public static final int SHORT_WAIT = 10;
    public static final int LONG_WAIT = 20;


    // -------------------------------------------------------------------- Waiting Time
    public static final String VALUE = "value";


    public static final String FE = "FE";
    public static final String BE = "BE";


    // -------------------------------------------------------------------- Groups

    public static final String LOGIN_GROUP = "Login";
    public static final String WESTERN_UNION_GROUP= "Western Union";

    // -------------------------------------------------------------------- Western Union
    public static final String WESTERN_UNION = "Western Union";

    //---EN

    //---RO
    public static final String RO_WU_TOOLTIP_TEXT ="Completeaza suma si moneda ce doresti sa o incasezi prin Western Union";
    public static final String RO_MTCN_LABEL = "Numar de control (MTCN)";
    public static final String RO_REMAINING_CHARACTERS = "caractere disponibile";
    public static final String RO_MTCN_FIELD = "Introdu codul de verificare primit";
    public static final String RO_OBLIGATORY_FIELD = "Acest camp este obligatoriu.";
    public static final String RO_COUNTRY_LABEL = "Tara expediere";
    public static final String RO_COUNTRY_FIELD = "Introdu tara de unde primesti banii\n" + "e.g: Statele Unite, Germania, Romania, etc";
    public static final String RO_TC = "Termeni si conditii";
    public static final String RO_WU_ERROR_MESSAGE = "Acest camp este obligatoriu.";
    public static final String RO_RECEIVE_MONEY = "Primeste bani";


    // -------------------------------------------------------------------- MENU STRINGS


    // Login Page
    public static final String AUTH_ERROR_MSG = "The Username or Password you entered is not correct. Please try again.";


    // -------------------------- Titles
    //---BE
    public static final String LOGIN_TITLE = "CXP Manager - Login";
    public static final String MAIN_TITLE = "CXP Manager";
    public static final String GROUP_TITLE = "Groups";
    public static final String PORTAL_TITLE = "Portal page Management";
    //---FE
    //RO
    public static final String FE_LOGIN_TITLE_RO = "Conturile mele";




    public static final String LABEL_IS_NOT_CORRECT = " label is not correct";
    public static final String LOGO_IS_NOT_DISPLAYED = "logo is nto displayed";



}