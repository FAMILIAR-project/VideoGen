/**
 */
package videogenPlaylist;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Media File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link videogenPlaylist.MediaFile#getPath <em>Path</em>}</li>
 *   <li>{@link videogenPlaylist.MediaFile#getDuration <em>Duration</em>}</li>
 *   <li>{@link videogenPlaylist.MediaFile#getText <em>Text</em>}</li>
 *   <li>{@link videogenPlaylist.MediaFile#getXAxis <em>XAxis</em>}</li>
 *   <li>{@link videogenPlaylist.MediaFile#getYAxis <em>YAxis</em>}</li>
 * </ul>
 *
 * @see videogenPlaylist.VideogenPlaylistPackage#getMediaFile()
 * @model
 * @generated
 */
public interface MediaFile extends EObject {
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
	 * @see videogenPlaylist.VideogenPlaylistPackage#getMediaFile_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link videogenPlaylist.MediaFile#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(double)
	 * @see videogenPlaylist.VideogenPlaylistPackage#getMediaFile_Duration()
	 * @model
	 * @generated
	 */
	double getDuration();

	/**
	 * Sets the value of the '{@link videogenPlaylist.MediaFile#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(double value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see videogenPlaylist.VideogenPlaylistPackage#getMediaFile_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link videogenPlaylist.MediaFile#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>XAxis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XAxis</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XAxis</em>' attribute.
	 * @see #setXAxis(String)
	 * @see videogenPlaylist.VideogenPlaylistPackage#getMediaFile_XAxis()
	 * @model
	 * @generated
	 */
	String getXAxis();

	/**
	 * Sets the value of the '{@link videogenPlaylist.MediaFile#getXAxis <em>XAxis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XAxis</em>' attribute.
	 * @see #getXAxis()
	 * @generated
	 */
	void setXAxis(String value);

	/**
	 * Returns the value of the '<em><b>YAxis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YAxis</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YAxis</em>' attribute.
	 * @see #setYAxis(String)
	 * @see videogenPlaylist.VideogenPlaylistPackage#getMediaFile_YAxis()
	 * @model
	 * @generated
	 */
	String getYAxis();

	/**
	 * Sets the value of the '{@link videogenPlaylist.MediaFile#getYAxis <em>YAxis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YAxis</em>' attribute.
	 * @see #getYAxis()
	 * @generated
	 */
	void setYAxis(String value);

} // MediaFile
