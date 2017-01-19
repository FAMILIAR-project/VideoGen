/**
 */
package videogenPlaylist.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import videogenPlaylist.MediaFile;
import videogenPlaylist.VideogenPlaylistPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Media File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link videogenPlaylist.impl.MediaFileImpl#getPath <em>Path</em>}</li>
 *   <li>{@link videogenPlaylist.impl.MediaFileImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link videogenPlaylist.impl.MediaFileImpl#getText <em>Text</em>}</li>
 *   <li>{@link videogenPlaylist.impl.MediaFileImpl#getXAxis <em>XAxis</em>}</li>
 *   <li>{@link videogenPlaylist.impl.MediaFileImpl#getYAxis <em>YAxis</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MediaFileImpl extends MinimalEObjectImpl.Container implements MediaFile {
	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final double DURATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected double duration = DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getXAxis() <em>XAxis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXAxis()
	 * @generated
	 * @ordered
	 */
	protected static final String XAXIS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXAxis() <em>XAxis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXAxis()
	 * @generated
	 * @ordered
	 */
	protected String xAxis = XAXIS_EDEFAULT;

	/**
	 * The default value of the '{@link #getYAxis() <em>YAxis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYAxis()
	 * @generated
	 * @ordered
	 */
	protected static final String YAXIS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getYAxis() <em>YAxis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYAxis()
	 * @generated
	 * @ordered
	 */
	protected String yAxis = YAXIS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MediaFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VideogenPlaylistPackage.Literals.MEDIA_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VideogenPlaylistPackage.MEDIA_FILE__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(double newDuration) {
		double oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VideogenPlaylistPackage.MEDIA_FILE__DURATION, oldDuration, duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VideogenPlaylistPackage.MEDIA_FILE__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXAxis() {
		return xAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXAxis(String newXAxis) {
		String oldXAxis = xAxis;
		xAxis = newXAxis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VideogenPlaylistPackage.MEDIA_FILE__XAXIS, oldXAxis, xAxis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYAxis() {
		return yAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYAxis(String newYAxis) {
		String oldYAxis = yAxis;
		yAxis = newYAxis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VideogenPlaylistPackage.MEDIA_FILE__YAXIS, oldYAxis, yAxis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VideogenPlaylistPackage.MEDIA_FILE__PATH:
				return getPath();
			case VideogenPlaylistPackage.MEDIA_FILE__DURATION:
				return getDuration();
			case VideogenPlaylistPackage.MEDIA_FILE__TEXT:
				return getText();
			case VideogenPlaylistPackage.MEDIA_FILE__XAXIS:
				return getXAxis();
			case VideogenPlaylistPackage.MEDIA_FILE__YAXIS:
				return getYAxis();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VideogenPlaylistPackage.MEDIA_FILE__PATH:
				setPath((String)newValue);
				return;
			case VideogenPlaylistPackage.MEDIA_FILE__DURATION:
				setDuration((Double)newValue);
				return;
			case VideogenPlaylistPackage.MEDIA_FILE__TEXT:
				setText((String)newValue);
				return;
			case VideogenPlaylistPackage.MEDIA_FILE__XAXIS:
				setXAxis((String)newValue);
				return;
			case VideogenPlaylistPackage.MEDIA_FILE__YAXIS:
				setYAxis((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VideogenPlaylistPackage.MEDIA_FILE__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case VideogenPlaylistPackage.MEDIA_FILE__DURATION:
				setDuration(DURATION_EDEFAULT);
				return;
			case VideogenPlaylistPackage.MEDIA_FILE__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case VideogenPlaylistPackage.MEDIA_FILE__XAXIS:
				setXAxis(XAXIS_EDEFAULT);
				return;
			case VideogenPlaylistPackage.MEDIA_FILE__YAXIS:
				setYAxis(YAXIS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VideogenPlaylistPackage.MEDIA_FILE__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case VideogenPlaylistPackage.MEDIA_FILE__DURATION:
				return duration != DURATION_EDEFAULT;
			case VideogenPlaylistPackage.MEDIA_FILE__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case VideogenPlaylistPackage.MEDIA_FILE__XAXIS:
				return XAXIS_EDEFAULT == null ? xAxis != null : !XAXIS_EDEFAULT.equals(xAxis);
			case VideogenPlaylistPackage.MEDIA_FILE__YAXIS:
				return YAXIS_EDEFAULT == null ? yAxis != null : !YAXIS_EDEFAULT.equals(yAxis);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (path: ");
		result.append(path);
		result.append(", duration: ");
		result.append(duration);
		result.append(", text: ");
		result.append(text);
		result.append(", xAxis: ");
		result.append(xAxis);
		result.append(", yAxis: ");
		result.append(yAxis);
		result.append(')');
		return result.toString();
	}

} //MediaFileImpl
