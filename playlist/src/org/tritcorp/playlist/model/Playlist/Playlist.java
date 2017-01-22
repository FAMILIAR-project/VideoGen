/**
 */
package org.tritcorp.playlist.model.Playlist;

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
 *   <li>{@link org.tritcorp.playlist.model.Playlist.Playlist#getFiles <em>Files</em>}</li>
 * </ul>
 *
 * @see org.tritcorp.playlist.model.Playlist.PlaylistPackage#getPlaylist()
 * @model
 * @generated
 */
public interface Playlist extends EObject {
	/**
	 * Returns the value of the '<em><b>Files</b></em>' reference list.
	 * The list contents are of type {@link org.tritcorp.playlist.model.Playlist.MediaFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Files</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Files</em>' reference list.
	 * @see org.tritcorp.playlist.model.Playlist.PlaylistPackage#getPlaylist_Files()
	 * @model
	 * @generated
	 */
	EList<MediaFile> getFiles();

} // Playlist
