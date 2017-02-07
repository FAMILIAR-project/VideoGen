/**
 */
package videogenPlaylist;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Playlist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link videogenPlaylist.Playlist#getMediaFile <em>Media File</em>}</li>
 * </ul>
 *
 * @see videogenPlaylist.VideogenPlaylistPackage#getPlaylist()
 * @model
 * @generated
 */
public interface Playlist extends EObject {
	/**
	 * Returns the value of the '<em><b>Media File</b></em>' reference list.
	 * The list contents are of type {@link videogenPlaylist.MediaFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Media File</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Media File</em>' reference list.
	 * @see videogenPlaylist.VideogenPlaylistPackage#getPlaylist_MediaFile()
	 * @model
	 * @generated
	 */
	EList<MediaFile> getMediaFile();

} // Playlist
