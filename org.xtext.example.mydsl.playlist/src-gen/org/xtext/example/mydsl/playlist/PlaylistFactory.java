/**
 * generated by Xtext 2.10.0
 */
package org.xtext.example.mydsl.playlist;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.xtext.example.mydsl.playlist.PlaylistPackage
 * @generated
 */
public interface PlaylistFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PlaylistFactory eINSTANCE = org.xtext.example.mydsl.playlist.impl.PlaylistFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Generator Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Generator Model</em>'.
   * @generated
   */
  PlaylistGeneratorModel createPlaylistGeneratorModel();

  /**
   * Returns a new object of class '<em>Mediafile</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mediafile</em>'.
   * @generated
   */
  Mediafile createMediafile();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  PlaylistPackage getPlaylistPackage();

} //PlaylistFactory
