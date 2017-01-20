/**
 */
package playlist;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link playlist.PlaylistModel#getMedia <em>Media</em>}</li>
 * </ul>
 *
 * @see playlist.PlaylistPackage#getPlaylistModel()
 * @model
 * @generated
 */
public interface PlaylistModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Media</b></em>' containment reference list.
	 * The list contents are of type {@link playlist.Media}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Media</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Media</em>' containment reference list.
	 * @see playlist.PlaylistPackage#getPlaylistModel_Media()
	 * @model containment="true"
	 * @generated
	 */
	EList<Media> getMedia();

	void eSetOne(int featureID, Object newValue);

} // PlaylistModel
