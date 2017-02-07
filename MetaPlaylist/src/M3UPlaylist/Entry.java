/**
 */
package M3UPlaylist;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link M3UPlaylist.Entry#getPath <em>Path</em>}</li>
 *   <li>{@link M3UPlaylist.Entry#isDiscontinuity <em>Discontinuity</em>}</li>
 *   <li>{@link M3UPlaylist.Entry#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @see M3UPlaylist.M3UPlaylistPackage#getEntry()
 * @model
 * @generated
 */
public interface Entry extends EObject {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see M3UPlaylist.M3UPlaylistPackage#getEntry_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link M3UPlaylist.Entry#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Discontinuity</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Discontinuity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Discontinuity</em>' attribute.
	 * @see #setDiscontinuity(boolean)
	 * @see M3UPlaylist.M3UPlaylistPackage#getEntry_Discontinuity()
	 * @model default="false"
	 * @generated
	 */
	boolean isDiscontinuity();

	/**
	 * Sets the value of the '{@link M3UPlaylist.Entry#isDiscontinuity <em>Discontinuity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Discontinuity</em>' attribute.
	 * @see #isDiscontinuity()
	 * @generated
	 */
	void setDiscontinuity(boolean value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(Integer)
	 * @see M3UPlaylist.M3UPlaylistPackage#getEntry_Duration()
	 * @model default="-1"
	 * @generated
	 */
	Integer getDuration();

	/**
	 * Sets the value of the '{@link M3UPlaylist.Entry#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(Integer value);

} // Entry
