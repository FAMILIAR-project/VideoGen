/**
 */
package M3UPlaylist.impl;

import M3UPlaylist.Entry;
import M3UPlaylist.M3UPlaylistPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link M3UPlaylist.impl.EntryImpl#getPath <em>Path</em>}</li>
 *   <li>{@link M3UPlaylist.impl.EntryImpl#isDiscontinuity <em>Discontinuity</em>}</li>
 *   <li>{@link M3UPlaylist.impl.EntryImpl#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntryImpl extends MinimalEObjectImpl.Container implements Entry {
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
	 * The default value of the '{@link #isDiscontinuity() <em>Discontinuity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDiscontinuity()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISCONTINUITY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDiscontinuity() <em>Discontinuity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDiscontinuity()
	 * @generated
	 * @ordered
	 */
	protected boolean discontinuity = DISCONTINUITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final Integer DURATION_EDEFAULT = new Integer(-1);

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected Integer duration = DURATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return M3UPlaylistPackage.Literals.ENTRY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, M3UPlaylistPackage.ENTRY__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDiscontinuity() {
		return discontinuity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiscontinuity(boolean newDiscontinuity) {
		boolean oldDiscontinuity = discontinuity;
		discontinuity = newDiscontinuity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, M3UPlaylistPackage.ENTRY__DISCONTINUITY, oldDiscontinuity, discontinuity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(Integer newDuration) {
		Integer oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, M3UPlaylistPackage.ENTRY__DURATION, oldDuration, duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case M3UPlaylistPackage.ENTRY__PATH:
				return getPath();
			case M3UPlaylistPackage.ENTRY__DISCONTINUITY:
				return isDiscontinuity();
			case M3UPlaylistPackage.ENTRY__DURATION:
				return getDuration();
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
			case M3UPlaylistPackage.ENTRY__PATH:
				setPath((String)newValue);
				return;
			case M3UPlaylistPackage.ENTRY__DISCONTINUITY:
				setDiscontinuity((Boolean)newValue);
				return;
			case M3UPlaylistPackage.ENTRY__DURATION:
				setDuration((Integer)newValue);
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
			case M3UPlaylistPackage.ENTRY__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case M3UPlaylistPackage.ENTRY__DISCONTINUITY:
				setDiscontinuity(DISCONTINUITY_EDEFAULT);
				return;
			case M3UPlaylistPackage.ENTRY__DURATION:
				setDuration(DURATION_EDEFAULT);
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
			case M3UPlaylistPackage.ENTRY__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case M3UPlaylistPackage.ENTRY__DISCONTINUITY:
				return discontinuity != DISCONTINUITY_EDEFAULT;
			case M3UPlaylistPackage.ENTRY__DURATION:
				return DURATION_EDEFAULT == null ? duration != null : !DURATION_EDEFAULT.equals(duration);
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
		result.append(", discontinuity: ");
		result.append(discontinuity);
		result.append(", duration: ");
		result.append(duration);
		result.append(')');
		return result.toString();
	}

} //EntryImpl
