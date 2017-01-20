/**
 */
package playlist.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import playlist.PlaylistPackage;
import playlist.VideoMedia;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Video Media</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link playlist.impl.VideoMediaImpl#getVideoid <em>Videoid</em>}</li>
 *   <li>{@link playlist.impl.VideoMediaImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link playlist.impl.VideoMediaImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link playlist.impl.VideoMediaImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VideoMediaImpl extends MediaImpl implements VideoMedia {
	/**
	 * The default value of the '{@link #getVideoid() <em>Videoid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVideoid()
	 * @generated
	 * @ordered
	 */
	protected static final String VIDEOID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVideoid() <em>Videoid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVideoid()
	 * @generated
	 * @ordered
	 */
	protected String videoid = VIDEOID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final int DURATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected int duration = DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VideoMediaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PlaylistPackage.Literals.VIDEO_MEDIA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVideoid() {
		return videoid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVideoid(String newVideoid) {
		String oldVideoid = videoid;
		videoid = newVideoid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlaylistPackage.VIDEO_MEDIA__VIDEOID, oldVideoid, videoid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlaylistPackage.VIDEO_MEDIA__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(int newDuration) {
		int oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlaylistPackage.VIDEO_MEDIA__DURATION, oldDuration, duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlaylistPackage.VIDEO_MEDIA__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PlaylistPackage.VIDEO_MEDIA__VIDEOID:
				return getVideoid();
			case PlaylistPackage.VIDEO_MEDIA__LOCATION:
				return getLocation();
			case PlaylistPackage.VIDEO_MEDIA__DURATION:
				return getDuration();
			case PlaylistPackage.VIDEO_MEDIA__NAME:
				return getName();
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
			case PlaylistPackage.VIDEO_MEDIA__VIDEOID:
				setVideoid((String)newValue);
				return;
			case PlaylistPackage.VIDEO_MEDIA__LOCATION:
				setLocation((String)newValue);
				return;
			case PlaylistPackage.VIDEO_MEDIA__DURATION:
				setDuration((Integer)newValue);
				return;
			case PlaylistPackage.VIDEO_MEDIA__NAME:
				setName((String)newValue);
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
			case PlaylistPackage.VIDEO_MEDIA__VIDEOID:
				setVideoid(VIDEOID_EDEFAULT);
				return;
			case PlaylistPackage.VIDEO_MEDIA__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case PlaylistPackage.VIDEO_MEDIA__DURATION:
				setDuration(DURATION_EDEFAULT);
				return;
			case PlaylistPackage.VIDEO_MEDIA__NAME:
				setName(NAME_EDEFAULT);
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
			case PlaylistPackage.VIDEO_MEDIA__VIDEOID:
				return VIDEOID_EDEFAULT == null ? videoid != null : !VIDEOID_EDEFAULT.equals(videoid);
			case PlaylistPackage.VIDEO_MEDIA__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case PlaylistPackage.VIDEO_MEDIA__DURATION:
				return duration != DURATION_EDEFAULT;
			case PlaylistPackage.VIDEO_MEDIA__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (videoid: ");
		result.append(videoid);
		result.append(", location: ");
		result.append(location);
		result.append(", duration: ");
		result.append(duration);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //VideoMediaImpl
