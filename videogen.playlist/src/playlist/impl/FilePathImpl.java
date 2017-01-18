/**
 */
package playlist.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import playlist.FilePath;
import playlist.PlaylistPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class FilePathImpl extends MinimalEObjectImpl.Container implements FilePath {
	
	private String path;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FilePathImpl(String path) {
		super();
		this.path = path;
	}
	
	protected FilePathImpl() {
		super();
		path = "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PlaylistPackage.Literals.FILE_PATH;
	}
	
	@Override
	public void setPath(String path){
		this.path = path;
	}
	
	@Override
	public String getPath() {
		return path;
	}

} //FilePathImpl
