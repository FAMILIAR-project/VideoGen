/**
 */
package playlist;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link playlist.MetaData#getDuree <em>Duree</em>}</li>
 *   <li>{@link playlist.MetaData#getDetails <em>Details</em>}</li>
 * </ul>
 *
 * @see playlist.PlaylistPackage#getMetaData()
 * @model
 * @generated
 */
public interface MetaData extends EObject {
	/**
	 * Returns the value of the '<em><b>Duree</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duree</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duree</em>' attribute.
	 * @see #setDuree(int)
	 * @see playlist.PlaylistPackage#getMetaData_Duree()
	 * @model
	 * @generated
	 */
	int getDuree();

	/**
	 * Sets the value of the '{@link playlist.MetaData#getDuree <em>Duree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duree</em>' attribute.
	 * @see #getDuree()
	 * @generated
	 */
	void setDuree(int value);

	/**
	 * Returns the value of the '<em><b>Details</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Details</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Details</em>' attribute.
	 * @see #setDetails(String)
	 * @see playlist.PlaylistPackage#getMetaData_Details()
	 * @model
	 * @generated
	 */
	String getDetails();

	/**
	 * Sets the value of the '{@link playlist.MetaData#getDetails <em>Details</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Details</em>' attribute.
	 * @see #getDetails()
	 * @generated
	 */
	void setDetails(String value);

} // MetaData
