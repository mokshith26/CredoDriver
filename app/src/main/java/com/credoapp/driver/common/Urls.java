package com.credoapp.driver.common;

public class Urls {

//google places api
//    AIzaSyDP8fEpJJDMm-EyqN90vSWQmev5RlV_ueo



    public static final String BASE_URL_DRIVER ="https://itsmytutor.com/api/";

    public static final String LOGIN_ = BASE_URL_DRIVER +"institutions/login?";

    public static final String CHANGE_PWD_ = BASE_URL_DRIVER +"institutions/change_password?";

    public static final String EMPLOYEE_ENTRY_FORM = BASE_URL_DRIVER +"institutions/save_employee_entry?";

    public static final String STUDENT_ENTRY_FORM = BASE_URL_DRIVER +"institutions/save_student_entry?";

    public static final String GET_QUALIFICATION = BASE_URL_DRIVER +"institutions/get_qualifications?";

    public static final String GET_BULK_DATA = BASE_URL_DRIVER +"institutions/get_bulk_data?";

    public static final String FORGOT_PASSWORD = BASE_URL_DRIVER +"institutions/forgotPassword?";

    public static final String VERIFY_OTP_FOR_FORGOT_PASSWORD = BASE_URL_DRIVER +"institutions/verifyOTP?";

    public static final String RESET_PASSWORD = BASE_URL_DRIVER +"institutions/resetPassword";

//    public static final String STUDENTS_LIST = BASE_URL_DRIVER +"institutions/get_students_by_institute?";

    public static final String STUDENTS_LIST = BASE_URL_DRIVER +"institutions/getBatchStudents?";

    public static final String NOTIFICATION = BASE_URL_DRIVER +"institutions/get_notification?";

    public static final String NOTIFICATION_STATUS = BASE_URL_DRIVER +"institutions/notification_status?";

    public static final String STUDENT_ATTENDANCE = BASE_URL_DRIVER +"institutions/update_student_attendance";

    public static final String STUDENT_ATTENDANCE_DETAILS_LIST = BASE_URL_DRIVER +"institutions/student_attendance";

    public static final String SEARCH_STUDENT_ATTENDANCE = BASE_URL_DRIVER +"institutions/search_attendance";

    public static final String GET_STUDENT_NAMES = BASE_URL_DRIVER +"institutions/getBatchStudents";

    //public static final String SAVE_MONTHLY_FEE_DATA = BASE_URL_DRIVER +"institutions/save_student_month_fee_entry";

    public static final String SAVE_CLASS_WISE_FEE_DATA = BASE_URL_DRIVER +"institutions/saveClassFeeEntry";

    //public static final String SAVE_COURSE_FEE_DATA = BASE_URL_DRIVER +"institutions/save_student_course_fee_entry";

    public static final String UPDATE_PUSH_TOKEN = BASE_URL_DRIVER+"institutions/update_institute_app_token";

    public static final String DASHBOARD_STATISTICS = BASE_URL_DRIVER +"institutions/dashboard_statistics";

    public static final String CONTACTS_LIST = BASE_URL_DRIVER +"parents/contactlist";

    public static final String BATCHES_LIST = BASE_URL_DRIVER +"institutions/get_batches";


    public static final String ADD_BATCH_TO_LIST = BASE_URL_DRIVER +"institutions/add_batch";

    public static final String SEND_NOTIFICATION = BASE_URL_DRIVER + "Institutions/sendNotifications";

    public static final String SEARCH_PARENT_NUMBER = BASE_URL_DRIVER + "Institutions/searchParent";

    public static final String PAY_HISTORY = BASE_URL_DRIVER + "institutions/payHistory";

    public static final String MONTHLY_PAY_HISTORY = BASE_URL_DRIVER + "institutions/monthwise_payments";

    public static final String ADD_MONTH_PAYMENT_FIRST = BASE_URL_DRIVER + "institutions/save_student_month_fee_entry";

    public static final String GET_MONTHLY_PAYMENT_STATUS = BASE_URL_DRIVER +"institutions/checkMonthFeeSetupExists";

    public static final String GET_MONTHLY_PAYMENT_SECOND_DATA = BASE_URL_DRIVER +"institutions/getFeeAmounts";

    public static final String SEND_CLASS_WISE_DATA = BASE_URL_DRIVER +"institutions/save_student_class_fee_entry";

    public static final String EDIT_MONTHLY_FEE_DATA = BASE_URL_DRIVER +"institutions/editPaidHistory";

    public static final String SAVE_SECOND_PAYMENT_MONTHLY = BASE_URL_DRIVER +"institutions/save_payment";

    public static final String GET_MONTH_PAYMENT =BASE_URL_DRIVER +"institutions/payHistory" ;

    public static final String CLASS_WISE_SET_UP_LIST =BASE_URL_DRIVER +"institutions/getClassFees" ;

    public static final String DELETE_SINGLE_PAYMENT = BASE_URL_DRIVER + "institutions/deletePayment";

    public static final String ENQUIRE = BASE_URL_DRIVER + "institutions/send_enquiry";

    public static final String ENQUIRE_LIST = BASE_URL_DRIVER + "institutions/enquiriesList";

    public static final String PAYMENT_SPINNER_LIST = BASE_URL_DRIVER + "institutions/institute_plans";

    public static final String PAYMENT = BASE_URL_DRIVER + "institutions/add_payment_info";

    public static final String PAYMENT_LIST = BASE_URL_DRIVER + "institutions/get_payment_details";

    public static final String SEND_BILK_SMS = BASE_URL_DRIVER + "institutions/sendEnquiryBulkSms";

    public static final String SMS_COUNT_REQUEST = BASE_URL_DRIVER + "institutions/getSmsAvailableCount" ;

    public static final String DELETE_BATCH_STUDENT = BASE_URL_DRIVER + "institutions/deleteStudentorBatch" ;

    public static final String STUDENT_DETAILS = BASE_URL_DRIVER + "institutions/get_students_info";

    public static final String TOTAL_PAYMENT_OF_INSTITUTE = BASE_URL_DRIVER + "institutions/paymentDetails";

    public static final String OUT_FOR_ALL_BATCH_STUDENTS = BASE_URL_DRIVER + "institutions/updateStudentOutReport";

    public static final String UPDATE_STUDENT_DETAILS = BASE_URL_DRIVER + "institutions/updateStudentProfile";

    public static final String UPDATE_INSTITUTE =  BASE_URL_DRIVER + "itm/update_institute";

    public static final String GET_CATEGORIES = BASE_URL_DRIVER + "itm/get_institute_formdata";

    public static final String GET_DATA_FOR_UPDATE = BASE_URL_DRIVER + "itm/institute_update_formdata";

    public static final String ADD_IMAGE = BASE_URL_DRIVER + "institutions/addGalleryImages";

    public static final String DELETE_PHOTO = BASE_URL_DRIVER + "institutions/removeGalleryImage";

    public static final String PROMOTIONAL_PHOTO = BASE_URL_DRIVER + "promotion/getPromotionImg";

    public static final String EMPLOYEES_LIST = BASE_URL_DRIVER + "institutions/getPromotionImg";

    public static final String DELETE_VIDEO = BASE_URL_DRIVER + "institutions/getPromotionImg";

    public static final String GET_VIDEOS_LIST = BASE_URL_DRIVER + "institutions/getPromotionImg";

    public static final String ADD_VIDEO = BASE_URL_DRIVER + "institutions/getPromotionImg";

    public static final String GET_FEE_LIST = BASE_URL_DRIVER + "institutions/get_fee_reports";

    public static final String GET_STATISTICS = BASE_URL_DRIVER + "institutions/get_institute_statistics";

    public static final String STUDENTS_LIST_ATTENDANCE = BASE_URL_DRIVER + "institutions/inst_batch_attendance";

    public static final String STUDENTS_TAKE_ATTENDANCE = BASE_URL_DRIVER + "institutions/inst_student_attendance";

//    https://www.itsmytutor.com/api/institutions/get_institute_statistics
//
}
