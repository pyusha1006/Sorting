/**
 * 
 */
package com.genworth.wcm.learningcenter.model;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 308002317
 * 
 */
public class User {
	private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
	private final ObjectMapper mapper = new ObjectMapper();

	private static final String CNAME = "user";
	private static final String C_OTP = "s_otp";
	private static final String COMMA = ",";
	private static final String COLON = ":";
	private static final String QUOTE = "\"";

	private DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	private Map<String, String> applicantDICT, bioDICT, ropDICT;

	private String firstName, lastName, userEmail, residentState, dob, dailyMonthly, applicantType, enrollmentStatus,
			firstTimeEntry, functionalState, grpId, grpUsrId, grpFullName, plcyFormNumber, newHireInd, hiredDate,
			selectedPremium, appStartedInd, appCompletedInd, appPercentageComp, userId, quoteName, quoteDate,
			applicationId, signedDate, lastSavedPage, sfdcId, otpTimestamp, generateOTP, monthlyMax, benefitYears,
			totalCoverage, bioOption, nfoChoice, ropChoice, informalCare, premiumAmount, nfoOption, ropOption,
			referenceUser, referencequotes;
	String hiredServerDate;

	public String getHiredServerDate() {
		return hiredServerDate;
	}

	public void setHiredServerDate(String hiredServerDate) {
		this.hiredServerDate = hiredServerDate;
	}

	public User() {
		System.out.println("I'm initiated");
		applicantDICT = new HashMap<String, String>();
		applicantDICT.put("E", "employee");
		applicantDICT.put("P", "part-time");
		applicantDICT.put("S", "spouse");
		applicantDICT.put("R", "retiree");
		applicantDICT.put("X", "spousePart-time");
		applicantDICT.put("Y", "retireeSpouse");
		applicantDICT.put("O", "other");

		bioDICT = new HashMap<String, String>();
		bioDICT.put("FPO", "01");
		bioDICT.put("GPO", "02");
		bioDICT.put("NONE", "03");
		bioDICT.put("ABI-5", "04");
		bioDICT.put("ABI-4", "07");
		bioDICT.put("ABI-3", "06");
		bioDICT.put("ABI-2", "08");
		bioDICT.put("5% Compound", "04");
		bioDICT.put("4% Compound", "07");
		bioDICT.put("3% Compound", "06");
		bioDICT.put("2% Compound", "08");

		ropDICT = new HashMap<String, String>();
		ropDICT.put("Yes", "03");
		ropDICT.put("No", "04");
		ropDICT.put("Y", "03");
		ropDICT.put("N", "04");
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail
	 *            the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the residentState
	 */
	public String getResidentState() {
		return residentState;
	}

	/**
	 * @param residentState
	 *            the residentState to set
	 */
	public void setResidentState(String residentState) {
		this.residentState = residentState;
	}

	/**
	 * @return the applicantType
	 */
	public String getApplicantType() {
		return applicantType;
	}

	/**
	 * @param applicantType
	 *            the applicantType to set
	 */
	public void setApplicantType(String applicantType) {
		this.applicantType = applicantType;
	}

	/**
	 * @return the enrollmentStatus
	 */
	public String getEnrollmentStatus() {
		return enrollmentStatus;
	}

	/**
	 * @param enrollmentStatus
	 *            the enrollmentStatus to set
	 */
	public void setEnrollmentStatus(String enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the firstTimeEntry
	 */
	public String getFirstTimeEntry() {
		return firstTimeEntry;
	}

	/**
	 * @param firstTimeEntry
	 *            the firstTimeEntry to set
	 */
	public void setFirstTimeEntry(String firstTimeEntry) {
		this.firstTimeEntry = firstTimeEntry;
	}

	/**
	 * @return the functionalState
	 */
	public String getFunctionalState() {
		return functionalState;
	}

	/**
	 * @param functionalState
	 *            the functionalState to set
	 */
	public void setFunctionalState(String functionalState) {
		this.functionalState = functionalState;
	}

	/**
	 * @return the grpId
	 */
	public String getGrpId() {
		return grpId;
	}

	/**
	 * @param grpId
	 *            the grpId to set
	 */
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}

	/**
	 * @return the grpUsrId
	 */
	public String getGrpUsrId() {
		return grpUsrId;
	}

	/**
	 * @param grpUsrId
	 *            the grpUsrId to set
	 */
	public void setGrpUsrId(String grpUsrId) {
		this.grpUsrId = grpUsrId;
	}

	/**
	 * @return the grpFullName
	 */
	public String getGrpFullName() {
		return grpFullName;
	}

	/**
	 * @param grpFullName
	 *            the grpFullName to set
	 */
	public void setGrpFullName(String grpFullName) {
		this.grpFullName = grpFullName;
	}

	/**
	 * @return the plcyFormNumber
	 */
	public String getPlcyFormNumber() {
		return plcyFormNumber;
	}

	/**
	 * @param plcyFormNumber
	 *            the plcyFormNumber to set
	 */
	public void setPlcyFormNumber(String plcyFormNumber) {
		this.plcyFormNumber = plcyFormNumber;
	}

	/**
	 * @return the newHireInd
	 */
	public String getNewHireInd() {
		return newHireInd;
	}

	/**
	 * @param newHireInd
	 *            the newHireInd to set
	 */
	public void setNewHireInd(String newHireInd) {
		this.newHireInd = newHireInd;
	}

	/**
	 * @return the hiredDate
	 */
	public String getHiredDate() {
		return hiredDate;
	}

	/**
	 * @param hiredDate
	 *            the hiredDate to set
	 */
	public void setHiredDate(String hiredDate) {
		this.hiredDate = hiredDate;
		 String hiredServerDate=null;
		 String hiredServerMonth=null;
		 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		 Date hireDate = null;
		try {
			hireDate = sdf.parse(this.hiredDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(hireDate);
		hiredServerDate = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		hiredServerMonth = Integer.toString(cal.get(Calendar.MONTH));
		this.setHiredServerDate(hiredServerDate+"/"+hiredServerMonth);
	}

	/**
	 * @return the selectedPremium
	 */
	public String getSelectedPremium() {
		return selectedPremium;
	}

	/**
	 * @param selectedPremium
	 *            the selectedPremium to set
	 */
	public void setSelectedPremium(String selectedPremium) {
		this.selectedPremium = selectedPremium;
	}

	/**
	 * @return the appStartedInd
	 */
	public String getAppStartedInd() {
		return appStartedInd;
	}

	/**
	 * @param appStartedInd
	 *            the appStartedInd to set
	 */
	public void setAppStartedInd(String appStartedInd) {
		this.appStartedInd = appStartedInd;
	}

	/**
	 * @return the appCompletedInd
	 */
	public String getAppCompletedInd() {
		return appCompletedInd;
	}

	/**
	 * @param appCompletedInd
	 *            the appCompletedInd to set
	 */
	public void setAppCompletedInd(String appCompletedInd) {
		this.appCompletedInd = appCompletedInd;
	}

	/**
	 * @return the appPercentageComp
	 */
	public String getAppPercentageComp() {
		return appPercentageComp;
	}

	/**
	 * @param appPercentageComp
	 *            the appPercentageComp to set
	 */
	public void setAppPercentageComp(String appPercentageComp) {
		this.appPercentageComp = appPercentageComp;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the quoteName
	 */
	public String getQuoteName() {
		return quoteName;
	}

	/**
	 * @param quoteName
	 *            the quoteName to set
	 */
	public void setQuoteName(String quoteName) {
		this.quoteName = quoteName;
	}

	/**
	 * @return the quoteDate
	 */
	public String getQuoteDate() {
		return quoteDate;
	}

	/**
	 * @param quoteDate
	 *            the quoteDate to set
	 */
	public void setQuoteDate(String quoteDate) {
		this.quoteDate = quoteDate;
	}

	/**
	 * @return the signedDate
	 */
	public String getSignedDate() {
		return signedDate;
	}

	/**
	 * @param signedDate
	 *            the signedDate to set
	 */
	public void setSignedDate(String signedDate) {
		this.signedDate = signedDate;
	}

	/**
	 * @return the applicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}

	/**
	 * @param applicationId
	 *            the applicationId to set
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	/**
	 * @return the lastSavedPage
	 */
	public String getLastSavedPage() {
		return lastSavedPage;
	}

	/**
	 * @param lastSavedPage
	 *            the lastSavedPage to set
	 */
	public void setLastSavedPage(String lastSavedPage) {
		this.lastSavedPage = lastSavedPage;
	}

	/**
	 * @return the sfdcId
	 */
	public String getSfdcId() {
		return sfdcId;
	}

	/**
	 * @param sfdcId
	 *            the sfdcId to set
	 */
	public void setSfdcId(String sfdcId) {
		this.sfdcId = sfdcId;
	}

	/**
	 * @return the otpTimestamp
	 */
	public String getOtpTimestamp() {
		return otpTimestamp;
	}

	/**
	 * @param otpTimestamp
	 *            the otpTimestamp to set
	 */
	public void setOtpTimestamp(String otpTimestamp) {
		this.otpTimestamp = otpTimestamp;
	}

	/**
	 * @return the generateOTP
	 */
	public String getGenerateOTP() {
		return generateOTP;
	}

	/**
	 * @param generateOTP
	 *            the generateOTP to set
	 */
	public void setGenerateOTP(String generateOTP) {
		this.generateOTP = generateOTP;
	}

	private String jsonLike(String k, String v) {
		return QUOTE + k + QUOTE + COLON + QUOTE + v + QUOTE;
	}

	public String getMonthlyMax() {
		return monthlyMax;
	}

	public void setMonthlyMax(String monthlyMax) {
		this.monthlyMax = monthlyMax;
	}

	public String getBenefitYears() {
		return benefitYears;
	}

	public void setBenefitYears(String benefitYears) {
		this.benefitYears = benefitYears;
	}

	public String getTotalCoverage() {
		return totalCoverage;
	}

	public void setTotalCoverage(String totalCoverage) {
		this.totalCoverage = totalCoverage;
	}

	public String getBioOption() {
		return bioOption;
	}

	public void setBioOption(String bioOption) {
		this.bioOption = bioOption;
	}

	public String getNfoChoice() {
		return nfoChoice;
	}

	public void setNfoChoice(String nfoChoice) {
		this.nfoChoice = nfoChoice;
	}

	public String getRopChoice() {
		return ropChoice;
	}

	public void setRopChoice(String ropChoice) {
		this.ropChoice = ropChoice;
	}

	public String getInformalCare() {
		return informalCare;
	}

	public void setInformalCare(String informalCare) {
		this.informalCare = informalCare;
	}

	public String getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(String premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public String getNfoOption() {
		return nfoOption;
	}

	public void setNfoOption(String nfoOption) {
		this.nfoOption = nfoOption;
	}

	public String getRopOption() {
		return ropOption;
	}

	public void setRopOption(String ropOption) {
		this.ropOption = ropOption;
	}

	@Override
	public String toString() {
		StringBuilder obj = new StringBuilder("{");
		obj.append(jsonLike("id", this.userId)).append(COMMA);
		obj.append(jsonLike("fname", this.firstName)).append(COMMA);
		obj.append(jsonLike("lname", this.lastName)).append(COMMA);
		obj.append(jsonLike("email", this.userEmail)).append(COMMA);
		obj.append(jsonLike("quoteDate", getDateStr(this.quoteDate))).append(COMMA);
		obj.append(jsonLike("signedDate", this.signedDate)).append(COMMA);
		obj.append(jsonLike("state", this.residentState)).append(COMMA);
		obj.append(jsonLike("fState", this.functionalState)).append(COMMA);
		obj.append(jsonLike("dob", this.dob)).append(COMMA);
		obj.append(jsonLike("age", getUserAge(this.dob))).append(COMMA);
		obj.append(jsonLike("informalCare", this.informalCare)).append(COMMA);
		obj.append(jsonLike("appStarted", this.appStartedInd)).append(COMMA);
		obj.append(jsonLike("appCompleted", this.appCompletedInd)).append(COMMA);
		obj.append(jsonLike("hiredDate", this.hiredDate)).append(COMMA);
		obj.append(jsonLike("newHiredFlag", this.newHireInd)).append(COMMA);
		obj.append(jsonLike("applicant", applicantDICT.get(this.applicantType))).append(COMMA);
		obj.append(jsonLike("enroll_status", this.enrollmentStatus)).append(COMMA);
		// obj.append(jsonLike("ET", ET)).append(COMMA);
		// obj.append(jsonLike("NFO_states", NFO_STATES)).append(COMMA);
		obj.append(jsonLike("login", "false")).append(COMMA);
		// pending to setup
		obj.append(jsonLike("bp", this.benefitYears)).append(COMMA);
		obj.append(jsonLike("bio", bioDICT.get(this.bioOption))).append(COMMA);
		obj.append(jsonLike("grp", this.grpUsrId.toLowerCase())).append(COMMA);
		obj.append(jsonLike("nff", this.nfoChoice)).append(COMMA);
		obj.append(jsonLike("rop", ropDICT.get(this.ropChoice))).append(COMMA);
		obj.append(jsonLike("defaultQuote", this.premiumAmount)).append(COMMA);
		obj.append(jsonLike("referenceQuote", this.referenceUser)).append(COMMA);
		obj.append(jsonLike("fcm", this.monthlyMax.replace("$", "").replace(",", ""))).append(COMMA);
		obj.append(jsonLike("quoteName", this.quoteName));
		// obj.append(jsonLike("referencequotes",
		// buildRefQList(this.referencequotes)));
		obj.append("}");
		return obj.toString();
	}

	public String buildRefQList(String mess) {
		StringBuilder obj = new StringBuilder("[");
		try {
			JSONArray jsonArray = new JSONArray(mess.replaceAll("/", "-"));
			// LOGGER.info("REFERENCE Array length of " + jsonArray.length());
			if (jsonArray.length() > 5)
				return "[{\"status\":\"repush\"}]";

			for (int i = 0; i < jsonArray.length(); i++) {
				System.out.println("index: " + i);
				if (i > 0)
					obj.append(COMMA);

				Map<String, String> m = toMap(jsonArray.getJSONObject(i).toString());

				RefQuote rq = new RefQuote();
				BeanUtils.populate(rq, m);
				obj.append(rq.toString());
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		obj.append("]");
		LOGGER.info("REFERENCE QUOTE JSONA passed: " + obj.toString());
		return obj.toString();
	}

	public Map<String, String> toMap(String str) throws JsonParseException, JsonMappingException, IOException {
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		return mapper.readValue(str, new TypeReference<HashMap<String, String>>() {
		});
	}

	private String getUserAge(String dob) {
		Date now = new Date();
		Date user;
		try {
			user = formatter.parse(dob);
			long timeBetween = now.getTime() - user.getTime();
			double yearsBetween = timeBetween / 3.156e+10;
			return "" + (int) Math.floor(yearsBetween);
		} catch (ParseException e) {
			LOGGER.error("GetUserAge Exception: " + e.getMessage());
		}

		return null;
	}

	private String getDateStr(String millis) {
		long milliSeconds = Long.parseLong(millis);

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliSeconds);
		// System.out.println(formatter.format(calendar.getTime()));
		return formatter.format(calendar.getTime());
	}

	public void updateCookie(Cookie[] cookies, HttpServletResponse response) {
		LOGGER.info("updateCookie");
		try {
			LOGGER.info("updateCookie TRY");
			Cookie c = new Cookie(CNAME, "");
			Cookie dateCookie = new Cookie("date","");
			LOGGER.info("is cookies null? " + cookies);
			Map<String, String> toCMap = new HashMap<String, String>();
			Map<String, String> todateCookieMap = new HashMap<String, String>();
			if (null != cookies) {
				LOGGER.info("is cookies get inside? " + cookies);
				c = getCookieObj(cookies);
				dateCookie = getDateCookieObj(cookies);
				if (null != c && StringUtils.isNotBlank(c.getValue())) { // update
					byte[] bs = Base64.decodeBase64(c.getValue());
					String uCookie = IOUtils.toString(bs, "UTF-8");
					Map<String, String> cMap = toMap(uCookie);
					cMap.put("serverhiredDate", getHiredServerDate());
					toCMap.putAll(cMap);
				} else { // new
					c = new Cookie(CNAME, "");
				}
			}
			toCMap.putAll(toMap(this.toString()));
			// add Reference Quotes
			LOGGER.info("Received referencequotes: " + this.referencequotes);
			if (toCMap.containsKey("referencequotes"))
				toCMap.remove("referencequotes");
			LOGGER.info("Cookie Map after removed: " + toCMap.toString());
			if (StringUtils.isNotBlank(this.referencequotes))
				toCMap.put("referencequotes", buildRefQList(this.referencequotes));

			c.setValue(new String(Base64.encodeBase64(new JSONObject(toCMap).toString().getBytes("UTF-8"))));
			// cookie.setMaxAge(maxAge);
			c.setPath("/");
			response.addCookie(c);
			response.addCookie(dateCookie);
			

			deleteOTPCookie(cookies, response); // if there is an OTP pending
		} catch (Exception e) {
			LOGGER.info("USER cookies updated Exception: " + e);
		}
	}

	private void deleteOTPCookie(Cookie[] cookies, HttpServletResponse response) {
		for (Cookie cookie : cookies) {
			String cookieKey = cookie.getName();
			LOGGER.info("get all cookies: " + cookieKey);
			if (cookieKey.equalsIgnoreCase(C_OTP)) {
				LOGGER.info("OTP cookie found for removing: " + cookie.getValue());
				cookie.setValue(null);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
				break;
			}
		}
	}

	private Cookie getCookieObj(Cookie[] cookies) throws IOException {
		for (Cookie cookie : cookies) {
			String cookieKey = cookie.getName();
			String value = cookie.getValue();

			if (cookieKey.equalsIgnoreCase(CNAME)) {
				byte[] bs = Base64.decodeBase64(value);
				String cookieValue = IOUtils.toString(bs, "UTF-8");
				LOGGER.info("USER gets cookie: " + cookieValue);

				return cookie;
			}
		}
		return null;
	}
	
	private Cookie getDateCookieObj(Cookie[] cookies) throws IOException {
		for (Cookie cookie : cookies) {
			String dateCookieKey = cookie.getName();
			String dateValue = cookie.getValue();

			if (dateCookieKey.equalsIgnoreCase("date")) {
				byte[] bs = Base64.decodeBase64(dateValue);
				String dateCookieValue = IOUtils.toString(bs, "UTF-8");
				LOGGER.info("USER gets cookie: " + dateCookieValue);

				return cookie;
			}
		}
		return null;
	}

	public String getReferencequotes() {
		return referencequotes;
	}

	public void setReferencequotes(String referencequotes) {
		LOGGER.info("USER gets REFERENCE QUOTE: " + referencequotes);
		this.referencequotes = referencequotes;
	}

	public String getReferenceUser() {
		return referenceUser;
	}

	public void setReferenceUser(String referenceUser) {
		this.referenceUser = referenceUser;
	}

	public String getDailyMonthly() {
		return dailyMonthly;
	}

	public void setDailyMonthly(String dailyMonthly) {
		this.dailyMonthly = dailyMonthly;
	}

	public class RefQuote {
		private String firstName, lastName, applicantType, dob, userEmail, referenceEmail, quoteName, quoteCreationDate,
				disable, quoteId, residentState;

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getApplicantType() {
			return applicantType;
		}

		public void setApplicantType(String applicantType) {
			this.applicantType = applicantType;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getDisable() {
			return disable;
		}

		public void setDisable(String disable) {
			this.disable = disable;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}

		public String getQuoteId() {
			return quoteId;
		}

		public void setQuoteId(String quoteId) {
			this.quoteId = quoteId;
		}

		public String getReferenceEmail() {
			return referenceEmail;
		}

		public void setReferenceEmail(String referenceEmail) {
			this.referenceEmail = referenceEmail;
		}

		public String getQuoteName() {
			return quoteName;
		}

		public void setQuoteName(String quoteName) {
			this.quoteName = quoteName;
		}

		public String getQuoteCreationDate() {
			return quoteCreationDate;
		}

		public void setQuoteCreationDate(String quoteCreationDate) {
			this.quoteCreationDate = quoteCreationDate;
		}

		public String getResidentState() {
			return residentState;
		}

		public void setResidentState(String residentState) {
			this.residentState = residentState;
		}

		@Override
		public String toString() {
			StringBuilder obj = new StringBuilder("{");
			obj.append(jsonLike("firstName", this.firstName)).append(COMMA);
			obj.append(jsonLike("lastName", this.lastName)).append(COMMA);
			obj.append(jsonLike("applicantType", this.applicantType)).append(COMMA);
			obj.append(jsonLike("dob", this.dob)).append(COMMA);
			obj.append(jsonLike("disable", "" + this.disable)).append(COMMA);
			obj.append(jsonLike("userEmail", this.userEmail)).append(COMMA);
			obj.append(jsonLike("quoteId", "" + this.quoteId)).append(COMMA);
			obj.append(jsonLike("referenceEmail", this.referenceEmail)).append(COMMA);
			obj.append(jsonLike("quoteName", this.quoteName)).append(COMMA);
			obj.append(jsonLike("residentState", this.residentState)).append(COMMA);
			obj.append(jsonLike("quoteCreationDate", this.quoteCreationDate));
			obj.append("}");
			return obj.toString();
		}
	}
}
