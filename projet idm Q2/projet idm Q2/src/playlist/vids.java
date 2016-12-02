/**
 */
package playlist;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>vids</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link playlist.vids#getVideo <em>Video</em>}</li>
 * </ul>
 *
 * @see playlist.PlaylistPackage#getvids()
 * @model
 * @generated
 */
public interface vids extends EObject {
	/**
	 * Returns the value of the '<em><b>Video</b></em>' reference list.
	 * The list contents are of type {@link playlist.MediaFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Video</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Video</em>' reference list.
	 * @see playlist.PlaylistPackage#getvids_Video()
	 * @model
	 * @generated
	 */
	EList<MediaFile> getVideo();

} // vids
